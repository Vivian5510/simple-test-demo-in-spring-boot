package com.rosy;

import jakarta.annotation.PostConstruct;
import org.dromara.dynamictp.spring.annotation.EnableDynamicTp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamicTp
public class DynamicTpDemoApplication
{
//    @Value("${text2}")
//    private String text;
//
//    @PostConstruct
//    public void init() {
//        System.out.println("text from nacos = " + text);
//    }

    public static void main( String[] args ) {
        SpringApplication.run(DynamicTpDemoApplication.class);
    }
}
