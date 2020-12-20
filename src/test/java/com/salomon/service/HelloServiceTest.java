package com.salomon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class HelloServiceTest {
    
    @Inject
    HelloService helloService;
    
    @Test
    void hello_happyPath() {
        assertEquals("Hello, World!", helloService.hello());
    }
}
