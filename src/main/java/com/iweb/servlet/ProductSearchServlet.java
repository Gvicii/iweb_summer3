package com.iweb.servlet;

import com.iweb.dao.impl.ProductDAOImpl;
import com.iweb.pojo.Product;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author GUAN
 * @date 2022/8/15 9:53
 * @description 类的描述和介绍
 */
@WebServlet(urlPatterns = {"/searchProduct"})
public class ProductSearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("value"));
//        调用DAO 获取所有的商品对象 然后进行遍历
        //如果能够找到 则继续操作
        //如果找不到 则什么都不做
        List<Product> products = new ProductDAOImpl().list();
        Product p = null;
        for(Product product:products){
            if(product.getId()==id){
                //如果遍历之后 找到了 则将目标商品对象的引用 传递给p
                p = product;
                break;
            }
        }
        //如果找到了 则需要将对应的商品对象 转换成JSON格式的
        //字符串 通过响应 返回给ajax的响应函数
        //创建JSONObject对象
        JSONObject json = new JSONObject();
        //把product对象转换为一个JSONObejct对象 并作为一个
        //key value存放在JSON对象上
        json.put("product",JSONObject.fromObject(p));
//        设置中文响应编码
        resp.setContentType("text/html;charset=utf-8");
        //数据写入响应
        resp.getWriter().print(json);
    }
}
