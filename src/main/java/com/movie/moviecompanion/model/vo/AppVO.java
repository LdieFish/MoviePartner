package com.movie.moviecompanion.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 应用封装类
 */
@Data
public class AppVO implements Serializable {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "应用名称")
    private String appName;

    @Schema(description = "应用封面")
    private String cover;

    @Schema(description = "应用初始化的 prompt")
    private String initPrompt;

    @Schema(description = "代码生成类型（枚举）")
    private String codeGenType;

    @Schema(description = "部署标识")
    private String deployKey;

    @Schema(description = "部署时间")
    private LocalDateTime deployedTime;

    @Schema(description = "优先级")
    private Integer priority;

    @Schema(description = "创建用户id")
    private Long userId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "创建用户信息")
    private UserVO user;

    private static final long serialVersionUID = 1L;
} 