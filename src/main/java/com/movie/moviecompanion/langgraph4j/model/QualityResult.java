package com.movie.moviecompanion.langgraph4j.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 代码质量检查结果
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualityResult implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "是否通过质检")
    private Boolean isValid;

    @Schema(description = "错误列表")
    private List<String> errors;

    @Schema(description = "改进建议")
    private List<String> suggestions;
}