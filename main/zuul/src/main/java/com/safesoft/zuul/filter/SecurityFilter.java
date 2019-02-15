package com.safesoft.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class SecurityFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //pre路由之前
        //routing：路由之时
        // post： 路由之后
        // error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //filterOrder：过滤的顺序，越小优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //shouldFilter：这里可以写逻辑判断，是否要过滤，这里true，永远过滤
        return true;
    }


    /**
     * run：过滤器的具体逻辑
     */
    @Override
    public Object run() throws ZuulException {
        //获取Request与Response接口对象
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String securityToken = request.getParameter("token");
        if (securityToken==null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("request failure , you do not have security token");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //return null 表示直接越过此Filter
        return null;
    }
}
