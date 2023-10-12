package com.gibuhagae.gibuhagae.member.controller;


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

    @Slf4j
    @Controller
    @RequestMapping(value = {"/login", "/join", "/myPage", "/member"})
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

            @GetMapping("/member-admin")
            public String memberManagement() {

                return "member/member-admin";
            }
        }

