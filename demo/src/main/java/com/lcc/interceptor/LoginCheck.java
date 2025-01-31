package com.lcc.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lcc.pojo.Result;
import com.lcc.util.jwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginCheck implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(LoginCheck.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String url = request.getRequestURI().toString();
        log.info("请求的url:{}", url);


        if (url.contains("login")) {
            log.info("登录请求，放行");
            return true;
        }

        String jwt = request.getHeader("Authorization");

        if (!StringUtils.hasLength(jwt)) {
            log.info("token为空,返回未登录信息");
            Result error = Result.error("未登录");
            String notLogin = JSONObject.toJSONString(error);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(notLogin);
            return false;
        }

        //检测有没有Bearer，有就去掉
        if (jwt.contains("Bearer")) {
            jwt = jwt.replace("Bearer ", "");
        }

        try {
            jwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("token非法,返回未登录错误信息");
            Result error = Result.error("未登录");
            String notLogin = JSONObject.toJSONString(error);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(notLogin);
            return false;
        }

        log.info("token合法，放行");
        return  true;
    }

    private void setCorsHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("postHandle......");
    }

@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    System.out.println("afterCompletion......");
    }

}
