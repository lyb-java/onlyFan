package com.zm.service;

import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.AchievementReqDto;
import com.zm.dto.AchievementRspDto;
import com.zm.dto.PageViewDto;
import com.zm.entity.Achievement;
import com.zm.exception.ValidateException;

/**
 * 成绩信息表(Achievement)表服务接口
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:33
 */
public interface AchievementService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Achievement queryById(Integer id);

    /**
     * 新增数据
     *
     * @param reqDto 实例对象
     * @param userInfo 用户信息对象
     * @return 实例对象
     */
    Integer insert(AchievementReqDto reqDto, AccountDetailsDto userInfo) throws Exception;

    /**
     * 修改数据
     *
     * @param achievement 实例对象
     * @return 影响行数
     */
    Integer update(Achievement achievement) throws ValidateException;

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Integer deleteById(Integer id);

    /**
     * 查询后台学生成绩列表
     *
     * @param pageViewDto  查询条件
     * @return PageInfo<Achievement> 分页列表对象
     */
    PageInfo<Achievement> getAllPage(PageViewDto<AchievementReqDto> pageViewDto,AccountDetailsDto accountDetailsDto) throws ValidateException;
}
