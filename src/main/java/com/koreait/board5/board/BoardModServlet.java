package com.koreait.board5.board;

import com.koreait.board5.MyUtils;
import com.koreait.board5.dao.BoardDAO;
import com.koreait.board5.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (MyUtils.isLogout(req)) {
            res.sendRedirect("/board/login");
            return;
        }

        //TODO 여기서부터 다시...
        int iboard = MyUtils.getParameterInt(req, "iboard");
        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        BoardVO data = BoardDAO.selBoardDetail(param);
        req.setAttribute("data", data);

        MyUtils.disForward(req, res, "/board/mod");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = MyUtils.getParameterInt(req, "iboard");
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");

        BoardVO param = new BoardVO();

        param.setIboard(iboard);
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(MyUtils.getLoginUserIboard(req));

        int result = BoardDAO.updBoard(param);

        switch (result) {
            case 1:
                res.sendRedirect("/board/list");
                break;
            default:
                req.setAttribute("err", "수정을 실패하였습니다.");
                req.setAttribute("data", param);
                doGet(req, res);
                break;
        }

    }
}
