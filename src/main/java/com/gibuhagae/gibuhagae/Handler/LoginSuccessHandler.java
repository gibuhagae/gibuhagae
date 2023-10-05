package com.gibuhagae.gibuhagae.Handler;

import com.gibuhagae.gibuhagae.member.controller.MemberController;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//kCHRk2Q4cq
//CA9DC7E5523C4C5BECEDCF294A888AD4
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("onAuthenticationSuccess");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1);

//        HttpSession session = request.getSession();
//
//        Cookie[] cookies = request.getCookies();
//        if (cookies[0].getValue().equals("56D9F68BFF7EAD4F58DF8AADA9B8CC18")) {
//            System.out.println("중복");
//            response.sendRedirect("/");
//            return;
//        }
//        session.invalidate();
//        System.out.println("세션GetId: " + session.getId());
//
//        System.out.println("new LoginSuccessHandler()");
//        session.setMaxInactiveInterval(1000);
//
//        session.setAttribute("greeting", authentication.getName() + "님 반갑습니다.");
//
//        var member = session.getAttribute("greeting");
//        System.out.println(member.toString());
//
        response.sendRedirect("/");
    }
}