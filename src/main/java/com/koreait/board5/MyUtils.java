package com.koreait.board5;

import com.koreait.board5.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils {
    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        String path = "/WEB-INF/view" + jsp + ".jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }

    public static int parseStringToInt(String str) {
        return parseStingToInt(str, 0);
    }

    public static int parseStingToInt(String str, int defVal) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return defVal;
        }
    }

    public static int getParameterInt(HttpServletRequest req, String key) {
        String strVal = req.getParameter(key);
        int intVal = parseStringToInt(strVal);
        return intVal;
    }

    public static UserVO getLoginUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return (UserVO)session.getAttribute("loginUser");
    }

    public static boolean isLogin(HttpServletRequest req) {
        return getLoginUser(req) != null;
    }

    public static boolean isLogout(HttpServletRequest req) {
        return getLoginUser(req) == null;
    }

    //로그인 상태면 return pk값, 로그아웃 상태면 return 0
    public static int getLoginUserIboard(HttpServletRequest req) {
        UserVO loginUser = getLoginUser(req);
        return loginUser == null ? 0 : loginUser.getIuser();
        // TODO 집에가서 한번 더 보자
    }
}
