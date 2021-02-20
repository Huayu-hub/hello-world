package com.alice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class Sayhello {

    @RequestMapping("/hello")
    public  String Hello(){

        return "hello world!";

    }

    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    public String getUser(){
        return "Get";
    }

    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    public String postUser(){
        return "Post";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.PUT)
    public String putUser(){
        return "Put";
    }

    //@RequestMapping(value = "/user" , method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String detelUser(){
        return "Delet";
    }

    @RequestMapping("/test")
    public String testSay(){
        return "TEST";
    }

//    @RequestMapping(value = {"/","index.html"})
//    public String reIndex(){
//        return "index";
//    }

}
