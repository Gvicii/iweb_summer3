package com.iweb.servlet;

import com.iweb.dao.CategoryDAO;
import com.iweb.dao.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/12 8:58
 * @description 类的描述和介绍
 */
@WebServlet(urlPatterns = {"/addCategory"})
public class CategoryAddServlet extends HttpServlet {
    private static CategoryDAO dao = new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        Category c = new Category();
        c.setName(name);
        dao.add(c);
        resp.sendRedirect("/listCategory");

    }
}
