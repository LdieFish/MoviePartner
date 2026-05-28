package com.movie.moviecompanion.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户更新请求
 */
@Data
public class UserUpdateRequest implements Serializable {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户昵称")
    private String userName;

    @Schema(description = "用户头像")
    private String userAvatar;

    @Schema(description = "简介")
    private String userProfile;

    @Schema(description = "用户角色：user/admin")
    private String userRole;

    private static final long serialVersionUID = 1L;
}