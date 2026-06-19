package com.movie.moviecompanionai.controller;

import com.movie.moviecompanionai.service.ChatHistoryService;
import com.movie.moviecompanioncommon.annotation.AuthCheck;
import com.movie.moviecompanioncommon.common.BaseResponse;
import com.movie.moviecompanioncommon.common.ResultUtils;
import com.movie.moviecompanioncommon.constant.UserConstant;
import com.movie.moviecompanioncommon.exception.ErrorCode;
import com.movie.moviecompanioncommon.exception.ThrowUtils;
import com.movie.moviecompanionmodel.model.dto.chathistory.ChatHistoryQueryRequest;
import com.movie.moviecompanionmodel.model.entity.ChatHistory;
import com.movie.moviecompanionmodel.model.entity.User;
import com.movie.moviecompanionuser.innerService.InnerUserService;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 对话历史 控制层。
 *
 * @author master
 */
@RestController
@RequestMapping("/chatHistory")
@Tag(name = "对话历史接口")
public class ChatHistoryController {

    @Autowired
    private ChatHistoryService chatHistoryService;

    /**
     * 分页查询某个应用的对话历史（游标查询）
     *
     * @param appId          应用ID
     * @param pageSize       页面大小
     * @param lastCreateTime 最后一条记录的创建时间
     * @param request        请求
     * @return 对话历史分页
     */
    @GetMapping("/app/{appId}")
    @Operation(summary = "分页查询某个应用的对话历史（游标查询）")
    public BaseResponse<Page<ChatHistory>> listAppChatHistory(@PathVariable Long appId,
                                                              @RequestParam(defaultValue = "10") int pageSize,
                                                              @RequestParam(required = false) LocalDateTime lastCreateTime,
                                                              HttpServletRequest request) {
        User loginUser = InnerUserService.getLoginUser(request);
        Page<ChatHistory> result = chatHistoryService.listAppChatHistoryByPage(appId, pageSize, lastCreateTime, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 管理员分页查询所有对话历史
     *
     * @param chatHistoryQueryRequest 查询请求
     * @return 对话历史分页
     */
    @PostMapping("/admin/list/page/vo")
    @Operation(summary = "管理员分页查询所有对话历史")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<ChatHistory>> listAllChatHistoryByPageForAdmin(@RequestBody ChatHistoryQueryRequest chatHistoryQueryRequest) {
        ThrowUtils.throwIf(chatHistoryQueryRequest == null, ErrorCode.PARAMS_ERROR);
        long pageNum = chatHistoryQueryRequest.getPageNum();
        long pageSize = chatHistoryQueryRequest.getPageSize();
        // 查询数据
        QueryWrapper queryWrapper = chatHistoryService.getQueryWrapper(chatHistoryQueryRequest);
        Page<ChatHistory> result = chatHistoryService.page(Page.of(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(result);
    }
}
