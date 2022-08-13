package com.iweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/13 11:12
 */
@WebServlet(urlPatterns = {"/checkName"})
public class CheckNameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接受到请求");
        //        从请求中获取参数
        String name = req.getParameter("name");
//        我们希望根据接受到的参数据不同 给js返回不同的响应内容
        resp.setContentType("text/html;charset=utf-8");
        if(name.equals("llx")){
            resp.getWriter().println("呵呵 原来是个好男人");
        }else{
            resp.getWriter().println("呵呵 原来是个渣男");
        }
    }
}
