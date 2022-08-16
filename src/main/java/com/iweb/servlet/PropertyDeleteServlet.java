package com.iweb.servlet;

import com.iweb.dao.PropertyDAO;
import com.iweb.pojo.Property;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/16 16:06
 */
@WebServlet(urlPatterns = {"/deleteProperty"})
public class PropertyDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        int id = Integer.parseInt(req.getParameter("id"));
        //调用dao
        new PropertyDAO().delete(id);
        //由于是ajax请求 不需要进行页面跳转 只需要给前端返回一个字符串
        //让前端js验证就可以了
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("success");
    }
}
