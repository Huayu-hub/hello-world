package com.alice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class ChatRobet {

    private static String[] SetDiscourse = {
            "你好呀！",
            "你吃了吗？",
            "最近怎么样？",
            "晚安！",
            "起床了嘛？",
            "有事在忙",
            "有什么事吗？",
            "?",
            "夜深了，溜了溜了",
            "在看番呢"
    };

    @ResponseBody
    @GetMapping("/getsomething")
    public String reDiscourse()  {
        Random random = new Random();
        int index=random.nextInt(10);
        return SetDiscourse[index];
    }

}
