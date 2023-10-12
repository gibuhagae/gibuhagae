package com.gibuhagae.gibuhagae.member.controller;


import com.gibuhagae.gibuhagae.common.exception.member.MemberModifyException;
import com.gibuhagae.gibuhagae.common.exception.member.MemberRegistException;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.member.service.AuthenticationService;
import com.gibuhagae.gibuhagae.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/member")
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
    @GetMapping("list")
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
    public String insertMember(@ModelAttribute MemberDTO member, String zipcode, String address1, String address2,
                               RedirectAttributes rttr) throws MemberRegistException {

        String address = zipcode + "$" + address1 + "$" + address2;
        member.setAddress(address);
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setUserCode("ADMIN");
        member.setLoginType("일반");
        member.setActivationStatus("Y");

        memberService.insertMember(member);

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.insert"));

        return "redirect:/member/list";
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


    /* 회원 정보 화면 이동 (수정 가능) */
    @PostMapping("/modify")
    public String modifyMember(MemberDTO modifyMember, String zipCode, String address1, String address2,RedirectAttributes rttr) throws MemberModifyException {

        String address = zipCode + "$" + address1 + "$" + address2;
        modifyMember.setAddress(address);

        memberService.modifyMember(modifyMember);

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.modify"));

        return "redirect:/member/list";
    }



@Slf4j
@Controller
@RequestMapping(value = {"/login", "/join", "/myPage"})
public class MemberController {
    private final MemberService memberService;
//    private final AuthenticationService authenticationService;
//    private final MessageSourceAccessor messageSourceAccessor;
//    private final PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    public MemberController(MemberService memberService, AuthenticationService authenticationService, MessageSourceAccessor messageSourceAccessor, PasswordEncoder passwordEncoder) {
//        this.memberService = memberService;
//        this.authenticationService = authenticationService;
//        this.messageSourceAccessor = messageSourceAccessor;
//        this.passwordEncoder = passwordEncoder;
//    }

    /* 로그인 페이지 이동 */
    @GetMapping("/Login")
    public void registPage(){
        System.out.println("로그인 자바 호출");
    }

    /* 회원 가입 페이지 이동 */
    @GetMapping("/Join")
    public void joinPage(){
        System.out.println("회원가입 페이지 이동");
    }

    @PostMapping("/Join")
    public String memberJoin(@ModelAttribute MemberDTO member, RedirectAttributes rttr){

        System.out.println("회원가입 버튼 눌렀음.");

        memberService.joinMember(member);
        //rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.join"));

        return "redirect:/login/Login";
    }

    // 마이페이지 이동
    @GetMapping("/MyPage")
    public void myPage() {
        System.out.println("마이페이지");
    }
}
