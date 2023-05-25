package com.springboot.interceptor;

import com.springboot.annotation.Authorize;
import com.springboot.common.JwtHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 进入controller层之前拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Authorize authorize;
        // 如果是预检请求，直接返回true
        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            return true;
        }
        if (o instanceof HandlerMethod) {
            authorize = ((HandlerMethod) o).getMethodAnnotation(Authorize.class);
        } else {
            return true;
        }
        //没有声明需要权限,或者声明不验证权限
        if (authorize == null || !authorize.required()) {
            return true;
        }
        return JwtHelper.VerifyToken(httpServletRequest);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // System.out.println("处理请求完成后视图渲染之前的处理操作");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // System.out.println("视图渲染之后的操作");
    }
}
