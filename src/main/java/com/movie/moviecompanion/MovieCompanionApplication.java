package com.movie.moviecompanion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.movie.moviecompanion.mapper")
public class MovieCompanionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCompanionApplication.class, args);
    }

}
