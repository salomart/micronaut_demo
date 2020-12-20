package com.salomon.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;

import com.salomon.service.HelloService;

import io.micronaut.http.MediaType;

@Controller("/hello")
public class HelloController {

    @Inject
    private HelloService helloService;

    @Get 
    @Produces(MediaType.TEXT_PLAIN) 
    public String hello() {
        return helloService.hello(); 
    }
}
