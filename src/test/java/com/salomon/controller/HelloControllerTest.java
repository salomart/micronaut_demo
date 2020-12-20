package com.salomon.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import com.salomon.service.HelloService;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class HelloControllerTest {

    private static final String HELLO_STRING = "Hello World";
    
    @Inject
    HelloService helloService;
    
    @Inject
    @Client("/")
    RxStreamingHttpClient client;
    
    @Test
    void hello_happyPath() {
        when(helloService.hello()).thenReturn(HELLO_STRING);
        
        HttpRequest request = HttpRequest.GET("/hello");
        HttpResponse<String> response = client.toBlocking().exchange(request, String.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(HELLO_STRING, response.body());
    }
    
    @MockBean(HelloService.class) 
    HelloService helloService() {
        return mock(HelloService.class);
    }
}