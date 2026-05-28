package com.movie.moviecompanion.model.dto.user;

import com.movie.moviecompanion.common.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户昵称")
    private String userName;

    @Schema(description = "账号")
    private String userAccount;

    @Schema(description = "简介")
    private String userProfile;

    @Schema(description = "用户角色：user/admin")
    private String userRole;

    private static final long serialVersionUID = 1L;
}