package com.koreait.board5.board;

import com.koreait.board5.MyUtils;
import com.koreait.board5.dao.BoardDAO;
import com.koreait.board5.model.BoardVO;
import com.koreait.board5.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO)session.getAttribute("loginUser");

        if (MyUtils.isLogout(req)) {
            req.setAttribute("err", "로그인 해주세요!");
            req.getRequestDispatcher("/user/login").forward(req, res);
            // TODO 집에가서 다시보자
            return;
        }

        int iboard = MyUtils.getParameterInt(req, "iboard");

        BoardVO param = new BoardVO();

        param.setIboard(iboard);
        param.setWriter(loginUser.getIuser());

        int result = BoardDAO.delBoard(param);

        switch (result) {
            case 1:
                res.sendRedirect("/board/list");
                break;
            default:
                req.setAttribute("err", "삭제를 실패하였습니다.");
                doGet(req, res);
                break;
        }



    }

}
