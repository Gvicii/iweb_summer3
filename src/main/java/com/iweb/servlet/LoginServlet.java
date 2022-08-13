package com.iweb.servlet;


import com.iweb.dao.impl.UserDAOImpl;
import com.iweb.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author GUAN
 * @date 2022/8/13 9:16
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接受参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //创建对象 封装数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //调用DAO判断登录是否成功
        boolean isLogin = new UserDAOImpl().login(user);
        if(isLogin){
//            将该用户的数据存于session之后 用于交给后续的过滤器进行获取
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
//            跳转到分类管理页面
            resp.sendRedirect("/listCategory");
            return;
        }else {
//            登录不成功
            resp.sendRedirect("login.jsp");
        }



    }
}
