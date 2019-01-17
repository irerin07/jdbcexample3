package com.tistory.irerin07.servlet;

import com.tistory.irerin07.dto.Board;
import com.tistory.irerin07.service.BoardService;
import com.tistory.irerin07.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "FreeModifyServlet", urlPatterns = "/free/modify")
public class FreeModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String)session.getAttribute("emailinfo");
        String nickname = (String)session.getAttribute("nicknameinfo");
        Long userId = (Long)session.getAttribute("idinfo");

        if(email == null){
            System.out.println("-_-;;;;; 로그인 부탁!!");
            resp.sendRedirect("/login");
            return;
        }else{
            System.out.println("로그인 OK");
        }
        req.setAttribute("nickname", nickname);
        req.setAttribute("userId", userId);
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/freewrite.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Long userId = (Long)session.getAttribute("idinfo");
        System.out.println(userId);
//        String nickname = req.getParameter((String)session.getAttribute("nicknameinfo"));
//        System.out.println(nickname);
        String nickname = req.getParameter("nickname");
        System.out.println(nickname);

        String title = req.getParameter("title");
        System.out.println(title);
        String content = req.getParameter("content");
        System.out.println(content);

        BoardService boardService = new BoardServiceImpl();
        Board board = new Board(title, content, nickname, userId);
        boardService.addBoard(board);
        resp.sendRedirect("/writesuccess");
//        if(boardService.addBoard(board) > 0){
//            resp.sendRedirect("/writesuccess");
//        }
        //resp.sendRedirect("/free/list");
    }
}
