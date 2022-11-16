//package com.example.javaispig.session;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class webConfigurer implements WebMvcConfigurer {
//    @Autowired
//    private loginInterceptor loginInterceptor;
//    @Override
//    public void  addInterceptors(InterceptorRegistry registry){
//        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
//        ir.addPathPatterns("/*");
//        ir.excludePathPatterns("/login");
//        ir.excludePathPatterns("/register");
//        ir.excludePathPatterns("/**/*.html");
//        ir.excludePathPatterns("/**/*.js");
//        ir.excludePathPatterns("/**/*.css");
//    }
//}
