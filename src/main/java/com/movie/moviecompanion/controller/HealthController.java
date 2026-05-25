package com.movie.moviecompanion.controller;

import com.movie.moviecompanion.common.BaseResponse;
import com.movie.moviecompanion.common.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> health() {
        return ResultUtils.success("OK");
    }
}
