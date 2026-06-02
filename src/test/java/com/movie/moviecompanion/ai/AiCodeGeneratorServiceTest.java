package com.movie.moviecompanion.ai;

import com.movie.moviecompanion.ai.model.HtmlCodeResult;
import com.movie.moviecompanion.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;
    @Test
    void generateHtmlCode() {
        HtmlCodeResult s = aiCodeGeneratorService.generateHtmlCode("生成一个HTML页面，内容是电影《唐顿庄园》,不超过20行");
        Assertions.assertNotNull(s);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult s = aiCodeGeneratorService.generateMultiFileCode("生成一个HTML页面，内容是电影《唐顿庄园》,不超过30行");
        Assertions.assertNotNull(s);
    }

    @Test
    void testChatMemory() {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode("做个工具网站，总代码量不超过 20 行");
        Assertions.assertNotNull(result);
        result = aiCodeGeneratorService.generateHtmlCode("不要生成网站，告诉我你刚刚做了什么？");
        Assertions.assertNotNull(result);
        result = aiCodeGeneratorService.generateHtmlCode("做个工具网站，总代码量不超过 20 行");
        Assertions.assertNotNull(result);
        result = aiCodeGeneratorService.generateHtmlCode("不要生成网站，告诉我你刚刚做了什么？");
        Assertions.assertNotNull(result);
    }

}