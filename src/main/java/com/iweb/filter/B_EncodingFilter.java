package com.iweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GUAN
 * @date 2022/8/12 16:04
 * @description 类的描述和介绍
 */
@WebFilter(urlPatterns = {"/*"})
public class B_EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        我们利用过滤器会拦截所有请求的特性
        //可以在过滤器中对所有请求统一设置中文编码
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
