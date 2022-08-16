package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.PropertyDAO;
import com.iweb.pojo.Category;
import com.iweb.pojo.Property;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author GUAN
 * @date 2022/8/16 15:35
 */
@WebServlet(urlPatterns = {"/listProperty"})
public class PropertyListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //参数获取
        int cid = Integer.parseInt(req.getParameter("id"));
        //根据分类id获取该分类下的所有属性的集合
        List<Property> properties = new PropertyDAO().list(cid);
        //数据存入请求
        req.setAttribute("properties",properties);
        req.setAttribute("cid",cid);
        //通过转发传递数据,并跳转页面
        req.getRequestDispatcher("page/property/listProperty.jsp").forward(req,resp);
    }
}
