package com.koreait.board5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}
