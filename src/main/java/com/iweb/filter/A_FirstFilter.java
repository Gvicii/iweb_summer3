package com.iweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 测试使用的过滤器,写这个是为了证明我们有写注释,不像某些公司
 * @author GUAN
 * @date 2022/8/12 15:47
 */
@WebFilter(urlPatterns = {"/*"})
public class A_FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("可以通过重写init方法,来定义我们需要在过滤器启动的时候要做什么" +
                "Filter一定会随着tomcat的启动而自启动 如果filter启动失败" +
                "或者本身有编译错误 不仅filter不能使用 tomcat会无法启动" );
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //为了保证方法能够正常的调用,需要对参数进行类型转换
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp =(HttpServletResponse)response;
//        尝试在过滤器中 获取数据
        String ip = req.getRemoteAddr();
        String url = req.getRequestURL().toString();
        String uri = req.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String date = sdf.format(d);
//        打印
        System.out.printf("%s %s 访问了%s%n uri为:%s",date,ip,url,uri);
        //过滤器对请求进行放行 如果还有过滤器 则执行下一个过滤器
        //如果已经是最后一个过滤器,则开始访问对应的Servlet
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("在过滤器被销毁的时候所执行的方法 一般没什么用");
    }
}
