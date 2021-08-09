package com.example.springboot.response;

import com.example.springboot.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ResponseTest {

    //TEXT
    @GetMapping("/tests")
        public String tests(@RequestParam String account){
            return account;
    }

    //JSON
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;    //200 ok
    }
    // 201에 대한 응답은 어떻게 내려줄 것인가
    // responseEntity에 generic 타입
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
