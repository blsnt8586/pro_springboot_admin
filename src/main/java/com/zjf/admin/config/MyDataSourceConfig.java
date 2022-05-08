package com.zjf.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//@Configuration
public class MyDataSourceConfig {
    //默认的自动配置是没有才会配置hikiri的数据源
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //加入监控功能
        druidDataSource.setFilters("wall,stat");
        return druidDataSource;
    }

    /**
     * 配置druid的监控页功能
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<Servlet> servletServletRegistrationBean =
                new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        servletServletRegistrationBean.addInitParameter("loginUsername","admin");
        servletServletRegistrationBean.addInitParameter("loginPassword","123456");

        return servletServletRegistrationBean;
    }

    /**
     * webstatFilter用于采集web-jdbc关联监控的数据
     */

    @Bean
    public FilterRegistrationBean statFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ioc,/druid/*");
        return filterFilterRegistrationBean;

    }

}
