package com.zjf.admin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zjf.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @ResponseBody
    @GetMapping("/a")
    public String getAccountById(){

//        Account asf = new Account(123L, "asf", 12, "123@11");
        return "123";
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    /**
     * 发请求，来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.hasText(user.getUserName()) && "123456".equals(user.getPassword())){
            //把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html；重定向，防止表单重复提交
            return "redirect:/main.html";
        }else {
            //回到登录页面
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(){
//        log.info("当前方法{}","mainPage");
//        //是否登录 拦截器，过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
//
//        }else{
//            //回到登录页面
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }

//        ValueOperations<String, String> stringStringValueOperations =
//                redisTemplate.opsForValue();
//        String s = stringStringValueOperations.get("/main.html");
//        String s1 = stringStringValueOperations.get("/sql");
//        model.addAttribute("mainCount",s);
//        model.addAttribute("sqlCount",s1);

        return "main";
    }
}
