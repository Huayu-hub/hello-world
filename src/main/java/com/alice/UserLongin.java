package com.alice;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Enumeration;


@Controller
public class UserLongin {


    @PostMapping("/longin")
    public String usrLongin(@RequestParam("username") String username ,
                            @RequestParam("pad") String password ,
                            HttpSession session ,
                            Model model ,
                            HttpServletResponse response)  {

        model.addAttribute("msg","密码或者账号错误");    //返送信息
        User user = new User(username,password);
        //记录登陆

        if( ! StringUtils.isEmpty(username) && password.equals("123") )  {
            Cookie cookie = new Cookie("Id" , session.getId() );
            System.out.println("存入的Id为"+cookie.getName());
            response.addCookie(cookie);
            session.setAttribute("admin" , user);//判断登录信息正确性
            return "redirect:/main.html";            //跳转登陆页面
        }
        else
        return "Userlongin";    //返送登陆页面
    }

    @GetMapping("/main.html")
    public String testPage(Model model ,
                           HttpServletRequest request)  {
        Cookie[] cookie = request.getCookies();
        HttpSession session =request.getSession();
        if(cookie!=null)
        for(Cookie value : cookie)  {
            System.out.println(value.getName()+":"+value.getValue());
            if(value.getName().equals("Id"))
                return "main";
        }


        return "Userlongin";
    }


}
