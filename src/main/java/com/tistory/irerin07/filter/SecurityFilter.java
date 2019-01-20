package com.tistory.irerin07.filter;

import com.tistory.irerin07.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/free/delete", "/free/write", "/free/modify"})
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("요청이 올때");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        User logininfo = (User)session.getAttribute("logininfo");
        if(logininfo == null){
            response.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("서블릿이 실행된 이후");
    }
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("요청이 올때");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
//        StringBuffer url = (request.getRequestURL().append('?').append(request.getQueryString()));
//        String[] url2 = url.toString().split("8080");
//        String url3 = url2[1];
//
//        StringBuffer requestURL = request.getRequestURL();
//        String[] finalurl = requestURL.toString().split("8080");
//
//        String email = (String) session.getAttribute("emailinfo");
//        String nickname = (String) session.getAttribute("nicknameinfo");
//        Long userId = (Long) session.getAttribute("idinfo");
//
//
//        if (email == null && nickname == null && userId == null) {
//            response.sendRedirect("/login?url=" + url3);
//            return;
//        } else {
//            response.sendRedirect(url3);
//            filterChain.doFilter(servletRequest, servletResponse);
//            System.out.println("서블릿이 실행된 이후");
//            return;
//
//        }
//    }

    @Override
    public void destroy() {

    }
}
