package com.gibuhagae.gibuhagae.member.controller;

import com.gibuhagae.gibuhagae.member.dto.CustomUserDTO;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.member.dto.MemberFunctionInfosDTO;
import com.gibuhagae.gibuhagae.member.dto.NaverMemberDTO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = {"/login", "/join"})
public class MemberController {
    private final MemberService memberService;
    private final AuthenticationService authenticationService;
    private final MessageSourceAccessor messageSourceAccessor;
    private final PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, AuthenticationService authenticationService, MessageSourceAccessor messageSourceAccessor, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.authenticationService = authenticationService;
        this.messageSourceAccessor = messageSourceAccessor;
        this.passwordEncoder = passwordEncoder;
    }

    /* 로그인 페이지 이동 */
    @GetMapping("/Login")
    public void moveLoginPage() {
        System.out.println("로그인씬 진입");

        System.out.println(" 로그인 자바 호출");
        //System.out.println(httpServletRequest.getCookies()[0].getValue());
    }

    @PostMapping("/Login")
    public void connectLogin() {
        System.out.println("로그인 post 호출");

    }

    @GetMapping("/NaverCallback")
    public void moveNaverCallbackPage() {
        System.out.println("네이버 콜백 호출");
    }

    @PostMapping("/NaverCallback")
    public void connectNaver(@RequestBody HashMap<String, String> map) {
        System.out.println("네이버 post 콜백 호출");

        MemberDTO member = new MemberDTO();

        // NaverMemberDTO naverMember = new NaverMemberDTO()
//        id : localStorage.getItem("naverId"),
//                gender : localStorage.getItem("naverGender"),
//                name : localStorage.getItem("naverName"),
//                nickname : localStorage.getItem("naverNickname"),
//                age : localStorage.getItem("naverAge"),
//                email : localStorage.getItem("naverEmail"),
//                phone : localStorage.getItem("naverMobile"),
//                loginType : "naver",
//                token :localStorage.getItem("naverToken"),

        if (map.get("loginType").equals("naver")) {
            // 네이버 계정이 DB에 없다면 계정을 생성한다.
            if (memberService.selectMemberId(map.get("id")) == false) {

                member.setMemberName(map.get("name"));
                member.setMemberPhone(map.get("phone"));
                member.setEmail(map.get("email"));
                member.setPassword("123");
                member.setUserId(map.get("id"));
                member.setUserCode(map.get("userCode"));
                member.setLoginType(map.get("loginType"));

                memberService.joinMember(member, "", "", "", "");
//              MemberDTO member, String memberPhone2, String memberPhone3, String address, String rAddress
            }

        } else {
            System.out.println("로그인 타입 오류");
            return;
        }

        authenticationService.loadUserByUsername(member.getUserId());
    }

    @GetMapping("/KakaoLogin")
    public void moveKakaoPage() {
        System.out.println("카카오 로그인 자바 호출");
    }

    @GetMapping("/IdFind")
    public void moveIdPage() {
        System.out.println("아이디 찾기 페이지");
    }

    @PostMapping("/IdFind")
    @ResponseBody
    public List<MemberDTO> findId(@RequestBody HashMap<String, String> findInfoMaps) {
        String mName = findInfoMaps.get("name");
        String mEmail = findInfoMaps.get("email");

        List<MemberDTO> findIdInfoList = memberService.selectFindIdInfos(mName, mEmail);
        if (findIdInfoList == null) {
            return null;
        }

        return findIdInfoList;
    }

    @GetMapping("/IdFindResult")
    public void moveIdFindResult() {
        return;
    }

    @GetMapping("/PwdFind")
    public void movePwdPage() {
        System.out.println("비밀번호 찾기 페이지");
    }

    @PostMapping("/PwdFind")
    @ResponseBody
    public List<String> findPwd(@RequestBody HashMap<String, String> findInfoMaps) {
        String mId = findInfoMaps.get("id");
        String mName = findInfoMaps.get("name");
        String mEmail = findInfoMaps.get("email");

        List<String> retInfos = new ArrayList<>();

        // 가져온 데이터
        MemberDTO findIdAndNameAndEmail = memberService.selectFindPwdInfos(mId, mName, mEmail);
        if (findIdAndNameAndEmail == null) {
            retInfos.add("fail");
            return retInfos;
        }

        String tempPwd = memberService.generatePwd();

        // 새 비밀번호를 랜덤 생성하고 객체에 저장한다.
        memberService.modifyMemberPwdByUserId(findIdAndNameAndEmail.getUserId(), tempPwd);

        retInfos.add(mId);
        retInfos.add(mName);
        retInfos.add(tempPwd);
        retInfos.add(mEmail);
        return retInfos;
    }

    @GetMapping("/PwdFindResult")
    public void movePwdFindResult() {
        return;
    }

    @PostMapping("/PwdFindResult")
    public ResponseEntity<String> modifyPwdFindResult(String userId) {

        // 해당 페이지에 왔다는 것은 임시 비밀번호 발급이 완료된 상태 그러므로 암호화 처리하여 재저장한다.

        String contents = "비밀번호 암호화 처리 완료";

        MemberDTO member = memberService.getMemberById(userId);
        if (member == null) {
            contents = "멤버를 가져오지 못했습니다.";
        }

        // 암호화 처리
        String encodePwd = passwordEncoder.encode(member.getPassword());
        if (memberService.modifyMemberPwdByUserId(userId, encodePwd) == false)
            contents = "비번 암호화 처리 실패";

        return ResponseEntity.ok(contents);
    }

    /* 로그인 실패 시 */
    @PostMapping("/Loginfail")
    public String loginFailed(RedirectAttributes rttr) {
        System.out.println("로그인 실패");

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("error.login"));
        return "redirect:/login/Login";
    }

    /* 회원 가입 페이지 이동 */
    @GetMapping("/Join")
    public void joinPage() {
        System.out.println("회원가입 페이지 이동");
    }

    @PostMapping("/Join")
    public ResponseEntity<String> join(@RequestBody HashMap<String, String> joinMap) {

        System.out.println("회원가입 버튼 눌렀음.");

        MemberDTO member = new MemberDTO();
        member.setUserId(joinMap.get("id"));
        member.setPassword(joinMap.get("pwd"));
        member.setMemberName(joinMap.get("name"));
        member.setMemberPhone(joinMap.get("phone1"));
        member.setZipcode(joinMap.get("zipcode"));
        member.setEmail(joinMap.get("email"));

        boolean ret = memberService.joinMember(member, joinMap.get("phone2"), joinMap.get("phone3"), joinMap.get("addr"), joinMap.get("rAddr"));
        //rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.regist"));

        if (ret == false)
            return ResponseEntity.ok("회원가입 실패");

        return ResponseEntity.ok("회원가입 완료");
    }

    /* 아이디 중복 체크 : 비동기 통신
     * ResponseEntity : 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
     * (HttpStatus, HttpHeaders, HttpBody 를 포함한다)
     * 규약에 맞는 HttpResponse를 반환하는데 사용 목적이 있다. */
    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member) {

        log.info("Request Check ID : {}", member.getUserId());

        String result = "사용 가능한 아이디입니다.";

        if (memberService.selectMemberId(member.getUserId())) {
            result = "중복 된 아이디가 존재합니다.";

        }

        return ResponseEntity.ok(result);
    }

    public static HttpSession session;

    // 회원탈퇴
    @GetMapping("/delete")
    public String deleteMember(@AuthenticationPrincipal CustomUserDTO member, RedirectAttributes rttr) {

        log.info("login member : {}", member);

        memberService.removeMember(member.getUsername());

        SecurityContextHolder.clearContext();

        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.delete"));

        return "redirect:/";
    }
}
