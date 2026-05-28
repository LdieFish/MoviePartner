package com.movie.moviecompanion.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户创建请求
 */
@Data
public class UserAddRequest implements Serializable {

    @Schema(description = "用户昵称")
    private String userName;

    @Schema(description = "账号")
    private String userAccount;

    @Schema(description = "用户头像")
    private String userAvatar;

    @Schema(description = "用户简介")
    private String userProfile;

    @Schema(description = "用户角色: user, admin")
    private String userRole;

    private static final long serialVersionUID = 1L;
}