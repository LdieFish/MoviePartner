package com.movie.moviecompanionuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.movie.moviecompanionuser.mapper")
@ComponentScan("com.movie")
public class MovieCompanionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCompanionApplication.class, args);
    }

}
