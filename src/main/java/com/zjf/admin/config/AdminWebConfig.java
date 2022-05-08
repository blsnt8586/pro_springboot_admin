package com.zjf.admin.config;


import com.zjf.admin.interceptor.LoginInterceptor;
import com.zjf.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer接口的addInterceptors）
 * 3、指定拦截器规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * Filter、Interceptor的区别
     * Filter是Servlet定义的原生组件。好处，脱离spring应用也能使用
     * Interceptor是spring定义的接口，可以使用spring 自动装备的功能
     */
//    @Autowired
//    RedisUrlCountInterceptor countInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")//所有请求都会拦截，并且静态资源也会拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
//        registry.addInterceptor(countInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
