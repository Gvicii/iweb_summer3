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
 * @date 2022/8/12 9:24
 */
@WebServlet(urlPatterns = {"/updateCategory"})
public class CategoryUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        接受编辑表单中的信息数据
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
//        将数据封装成Category对象
        Category c = new Category(id,name);
        //调用DAO
        new CategoryDAOImpl().update(c);
//        重新访问/listServlet 获取更新之后的数据
        resp.sendRedirect("/listCategory");
    }
}
