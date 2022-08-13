package com.iweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/13 9:59
 * @description 类的描述和介绍
 */
@WebServlet(urlPatterns = {"/exitLogin"})
public class LoginExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect("login.jsp");
    }
}
