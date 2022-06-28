package com.shaker.springboottutorial.controller;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "<h1>Hello</h1>";
    }

    @GetMapping("/user")
    public String helloUser(){
        return "<h1>hello user</h1>";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "<h1>Hello admin</h1>";
    }
}
