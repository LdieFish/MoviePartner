package com.movie.moviecompanion.service;

import com.movie.moviecompanion.model.dto.app.AppQueryRequest;
import com.movie.moviecompanion.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.movie.moviecompanion.model.entity.App;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author master
 */
public interface AppService extends IService<App> {

    /**
     * 获取应用封装类
     *
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    List<AppVO> getAppVOList(List<App> appList);

    /**
     * 构造应用查询条件
     *
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);
}
