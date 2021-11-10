package com.example.demo;

import com.example.demo.formatter.StringToCategoryFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Configuration
    public class WebConfig implements WebMvcConfigurer {


        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new StringToCategoryFormatter());
        }


    }

}
