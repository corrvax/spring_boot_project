package com.eunjo.aws.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // -> /hello로 요청이오면 hello 문자열 반환
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
