package com.movie.moviecompanion;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.movie.moviecompanion.mapper")
public class MovieCompanionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCompanionApplication.class, args);
    }

}
