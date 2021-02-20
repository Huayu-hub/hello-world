package Zction;

import com.alibaba.druid.pool.DruidDataSource;
import com.alice.User;
import com.alice.Userc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



@Controller
public class Login {

    @Autowired
    UserMapper uermapper; //自动注入

    @Autowired
    DruidDataSource druidDataSource;


    /*首页跳转*/
    @GetMapping(value = {"/" , "/login"})
    public String reqToindex()  {

        return "Userlongin";
    }

    @PostMapping("/login")
    public String usrLogin(@RequestParam("username") String name ,
                           @RequestParam("pwd") String pwd ,
                           HttpSession session,
                           Model model)  {

        if(!name.isEmpty() && pwd.equals("123"))  {
            User user = new User(name , pwd ) ;
            session.setAttribute("userlogin" , user);
            return "redirect:/main.html";
        }  else {
            model.addAttribute("msg" , "erro");
            return "Userlongin";
        }


    }

    @GetMapping("/main.html")
    public String mainIndex()  {

        return "main";
    }

    @ResponseBody
    @PostMapping("/main.html")
    public String erroExcption()  {

        return "erro";
    }

    @ResponseBody
    @GetMapping("/my1")
    public Userc mybatisTest(@RequestParam("id") int id)  {

        Userc user = uermapper.getUser(id);

        return user ;
    }

    @ResponseBody
    @PostMapping("/my2")
    public String mybatisTest(@RequestParam("id") int id ,
                             @RequestParam("name") String name)  {

        uermapper.addUser(id , name );

        return "sueessful"+druidDataSource.getClass() ;
    }

}
