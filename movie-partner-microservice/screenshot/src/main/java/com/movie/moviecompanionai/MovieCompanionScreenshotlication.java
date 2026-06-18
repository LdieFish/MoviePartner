package com.movie.moviecompanionai;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubbo
@ComponentScan("com.movie")
public class MovieCompanionScreenshotlication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCompanionScreenshotlication.class, args);
    }

}