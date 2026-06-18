package com.movie.moviecompanionuser;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.movie.moviecompanionuser.mapper")
@ComponentScan("com.movie")
@EnableDubbo
public class MovieCompanionUserlication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCompanionUserlication.class, args);
    }

}
