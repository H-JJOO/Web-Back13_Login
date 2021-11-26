package com.koreait.board5.user;

import com.koreait.board5.MyUtils;
import com.koreait.board5.dao.UserDAO;
import com.koreait.board5.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MyUtils.disForward(req, res, "/user/login");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        UserVO param = new UserVO();

        param.setUid(uid);
        param.setUpw(upw);

        int result = UserDAO.login(param);

        //0:로그인실패, 1: 로그인성공, 2:아이디없음, 3:비밀번호틀림

        if (result == 1) {
            res.sendRedirect("/board/list");

            HttpSession session = req.getSession();
            session.setAttribute("loginUser", param);

            return;
        }
        String err = null;
        switch (result) {
            case 0 :
                err = "로그인에 실패하였습니다.";
                break;
            case 2 :
                err = "아이디를 확인해주세요.";
                break;
            case 3 :
                err = "비밀번호를 확인해주세요.";
                break;
        }
        req.setAttribute("err", err);
        doGet(req, res);






    }
}
