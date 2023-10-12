package com.gibuhagae.gibuhagae.member.controller;

import com.gibuhagae.gibuhagae.common.exception.member.MemberModifyException;
import com.gibuhagae.gibuhagae.common.exception.member.MemberRegistException;
import com.gibuhagae.gibuhagae.common.exception.member.MemberRemoveException;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.member.service.AuthenticationService;
import com.gibuhagae.gibuhagae.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/memberManagement")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    private final AuthenticationService authenticationService;

    private final PasswordEncoder passwordEncoder;

    private final MessageSourceAccessor messageSourceAccessor;

    public MemberController(MemberService memberService, AuthenticationService authenticationService, PasswordEncoder passwordEncoder, MessageSourceAccessor messageSourceAccessor) {
        this.memberService = memberService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
        this.messageSourceAccessor = messageSourceAccessor;
    }

    /* MemberList 조회 */
    @GetMapping("/member-admin")
    public String getMemberList(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(required = false) String searchCondition,
                                @RequestParam(required = false) String searchValue,
                                Model model) {

        log.info("memberList page : {}", page);
        log.info("memberList searchCondition : {}", searchCondition);
        log.info("memberList searchValue : {}", searchValue);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

       Map<String, Object> memberListAndPaging =  memberService.selectMemberList(searchMap, page);

        model.addAttribute("paging", memberListAndPaging.get("paging"));
        model.addAttribute("memberList", memberListAndPaging.get("memberList"));


        return "member/memberList";
    }

    /* 관리자 회원 insert */
    @PostMapping("/insert")
    public String insertMember(@ModelAttribute MemberDTO member, String address1, String address2,
                               RedirectAttributes rttr) throws MemberRegistException {

        String address =  address1 + "$" + address2;
        member.setAddress(address);
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setUserCode("ADMIN");
        member.setLoginType("일반");
        member.setActivationStatus("Y");

        memberService.insertMember(member);

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.insert"));

        return "redirect:/memberManagement/member-admin";
    }

    /* id 중복 체크 : 비동기 통신 */
    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member) {

        String result = "사용 가능한 아이디입니다.";

        if(memberService.selectMemberByUserId(member.getUserId())) {
            result = "중복 된 아이디가 존재합니다.";
        }

        return ResponseEntity.ok(result);
    }

    protected Authentication createNewAuthentication(String memberId) {

        UserDetails newPrincipal = authenticationService.loadUserByUsername(memberId);
        UsernamePasswordAuthenticationToken newAuth
                = new UsernamePasswordAuthenticationToken(newPrincipal, newPrincipal.getPassword(), newPrincipal.getAuthorities());

        return newAuth;
    }

    /* 회원정보 조회 및 수정 */
    @PostMapping("/member-admin/modify")
    public ResponseEntity<Void> modifyMember(@Param("fixNo") Long fixNo, @Param("inputDonatePrice") String inputDonatePrice, @Param("inputActivationStatus") String inputActivationStatus) throws MemberModifyException {

        MemberDTO member = new MemberDTO();
        member.setNo(fixNo);
        member.setDonatePrice(inputDonatePrice);
        member.setActivationStatus(inputActivationStatus);

        memberService.modifyMember(member);

        return ResponseEntity.ok().build();
    }



}
