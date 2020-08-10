package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Applications extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Applications.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(Applications.class);
    }
   /* @Override
    public void run(String... args) throws Exception {
        GroupRepository gr=null;
        System.out.println( gr.findByGroupName("ПМ-1").getGroupName());
    }*/
}
