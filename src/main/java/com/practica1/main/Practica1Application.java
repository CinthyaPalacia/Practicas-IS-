package com.practica1.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Practica1Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Practica1Application.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "Cinthya Paola Palafox Garcia") String name)
    {
        return String.format("Hello %s!", name);
    }
}
