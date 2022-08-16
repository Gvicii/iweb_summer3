package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
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
 * @date 2022/8/16 16:11
 */
@WebServlet(urlPatterns = {"/addProperty"})
public class PropertyAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //参数获取
        String name = req.getParameter("name");
        int cid = Integer.parseInt(req.getParameter("cid"));
        //属性对象封装
        Property property = new Property();
        property.setCategory(new CategoryDAO().get(cid));
        property.setName(name);
        //数据入库
        new PropertyDAO().add(property);
        //页面跳转
        resp.sendRedirect("/listProperty?id="+cid);
    }
}
