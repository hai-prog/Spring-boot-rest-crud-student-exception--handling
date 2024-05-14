package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHelloWorld()
    {
        return "Hello World!!!";
    }
}
