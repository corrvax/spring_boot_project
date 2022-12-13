package com.eunjo.aws.springboot.web;

import com.eunjo.aws.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // -> /hello로 요청이오면 hello 문자열 반환
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
        @RequestParam("amount")int amount){
        return new HelloResponseDto(name, amount);
    }

}
