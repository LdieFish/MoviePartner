package com.movie.moviecompanion.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    @Schema(description = "账号")
    private String userAccount;

    @Schema(description = "密码")
    private String userPassword;
}