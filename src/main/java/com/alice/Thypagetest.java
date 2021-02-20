package com.alice;

import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.MessageHeader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class Thypagetest {

    @GetMapping("/test/thpage")
    public String boundPage(Model model)  {
        model.addAttribute("msg" , "say");
        model.addAttribute("link" , "http://www.baidu.com");
        return "page2";
    }

    @GetMapping("/")
    public String pagetest()  {

        return "Userlongin";
    }



}
