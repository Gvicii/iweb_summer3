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
import java.util.List;

/** 默认负责查询所有分类的数据 并且将数据显示到listCategory.jsp页面上
 * @author GUAN
 * @date 2022/8/11 16:24
 */
@WebServlet(urlPatterns = {"/listCategory"})
public class CategoryListServlet extends HttpServlet {
    private static CategoryDAO dao  = new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取我们的对应的分类集合
        List<Category> categories = dao.list();
        //将集合存入到请求中
        req.setAttribute("categories",categories);
        //利用转发进行页面的跳转 并通过请求的作用域将数据传递给指定页面
        req.getRequestDispatcher("page/category/listCategory.jsp").forward(req,resp);
    }
}
