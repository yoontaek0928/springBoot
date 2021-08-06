package com.example.springboot.controller;

import com.example.springboot.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GetApiController {
    @GetMapping(path = "/hello")    // http://localhost:8080/api/hello
    public String hello(){
        return "get Hello!";
    }

    // 다른 방법으로는
    @RequestMapping(path="/hi", method = RequestMethod.GET)     // get http://localhost:8080/api/hi
    public String hi(){
        return "hi";
    }
    // Path Variable
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){       //이름을 일치시킬 수 없을 때
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }
    // Query Parameter
    // http://localhost:8080/api/query-parameter?user=eeyoontaek&email=eeyoontaek@gmail.com
    // Map으로 받는 경우에는 Key를 명확하게 알 수 없다.
    @GetMapping("/query-parameter")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue() + "\n");
        });
        return sb.toString();
    }

    //================
    // 키 값을 명확하게 줄 경우에는
    // 변수가 많은 경우에는 사용하기 불편함
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;

    }

    //========================================
    // 현업에서 가장 많이 사용
    // RequestParam 이라는 annotation 붙이지 않음
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
