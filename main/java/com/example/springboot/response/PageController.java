package com.example.springboot.response;

import com.example.springboot.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// page를 리턴하는 어노테이션
@Controller
public class PageController {
    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User();      // 타입 추론
        user.setName("steve");
        user.setAddress("패스트 캠퍼스");
        return user;
    }
}
