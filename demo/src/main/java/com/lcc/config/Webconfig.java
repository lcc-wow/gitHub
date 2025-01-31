package com.lcc.config;

import com.lcc.interceptor.LoginCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheck loginCheck;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginCheck).addPathPatterns("/**");
    }

}
