package com.tistory.irerin07.servlet;

import com.tistory.irerin07.dto.User;
import com.tistory.irerin07.service.UserService;
import com.tistory.irerin07.service.UserServiceImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");
        System.out.println("login servlet: " + url);
        req.setAttribute("url", url);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/loginform.jsp");
        requestDispatcher.forward(req, resp);
    }
    //let me test - Andy
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String passwd = req.getParameter("passwd");
        String url = req.getParameter("url");
        System.out.println("login doPost: "  + url);


        UserService userService = UserServiceImpl.getInstance();
        User user = userService.getUserByEmail(email);
        String encodePasswd = user.getPasswd();
        if(encodePasswd != null){
            PasswordEncoder passwordEncoder =
                    PasswordEncoderFactories.createDelegatingPasswordEncoder();
            boolean matches = passwordEncoder.matches(passwd, encodePasswd);
            if(matches){
                // 로그인정보를 세션에 저장.
                HttpSession session = req.getSession();
                session.setAttribute("logininfo", user);

                System.out.println("암호가 맞아요.");
            }else{
                // 암호가 틀렸어요.
                System.out.println("암호가 틀렸어요.");
            }
        }
        resp.sendRedirect("/free/list");
        // 로그인 성공했다면
//        if(url == null){
//            resp.sendRedirect("/free/list");
//        }else {
//            System.out.println("뭐지 시벌?");
//            resp.sendRedirect(url);
//        }
//        System.out.println(url);
//        resp.sendRedirect(url);
    }
}