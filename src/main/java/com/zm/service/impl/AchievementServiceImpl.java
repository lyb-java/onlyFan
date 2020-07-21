package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.AchievementReqDto;
import com.zm.dto.PageViewDto;
import com.zm.entity.Achievement;
import com.zm.entity.Student;
import com.zm.exception.ValidateException;
import com.zm.mapper.AchievementMapper;
import com.zm.mapper.StudentMapper;
import com.zm.service.AchievementService;
import com.zm.util.AssembleEntity;
import com.zm.util.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 成绩信息表(Achievement)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:33
 */
@Service("AchievementService")
public class AchievementServiceImpl implements AchievementService {
    @Resource
    private AchievementMapper achievementMapper;
    @Resource
    private StudentMapper studentMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Achievement queryById(Integer id) {
        return this.achievementMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *@param userInfo 实例对象
     * @param reqDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insert(AchievementReqDto reqDto, AccountDetailsDto userInfo) throws Exception {
        //赋值
        Achievement achievement = (Achievement)AssembleEntity.assembleEntityByClass(reqDto,Achievement.class,userInfo);
        //查询学生姓名
        Student student = studentMapper.selectByPrimaryKey(achievement.getStudentId());
        achievement.setStudentName(student.getName());
        //时间格式转换  考试起始时间
        String starTime = DateUtils.parseDate(reqDto.getStartingTime(),DateUtils.DATETIMEYYYYMMDD_HHMM);
        String endTime = DateUtils.parseDate(reqDto.getCompletionTime(),DateUtils.DATETIMEYYYYMMDD_HHMM);
        achievement.setStartTime(Long.parseLong(starTime));
        achievement.setEndTime(Long.parseLong(endTime));

        Integer result = this.achievementMapper.insert(achievement);
        return result;
    }

    /**
     * 修改数据
     *
     * @param achievement 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer update(Achievement achievement) throws ValidateException {
        Achievement rspDto =  this.queryById(achievement.getAchievementId());
        if(Objects.isNull(rspDto)){
            throw  new ValidateException("成绩信息不存在！");
        }
        Integer result =this.achievementMapper.updateByPrimaryKeySelective(achievement);
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer deleteById(Integer id) {
        return this.achievementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Achievement> getAllPage(PageViewDto<AchievementReqDto> pageViewDto) throws ValidateException {
        AchievementReqDto reqDto = new AchievementReqDto();
        //分页参数
        Page<Achievement> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        BeanUtils.copyProperties(pageViewDto.getCondition(), reqDto);
        //考试时间
        String startingTime = reqDto.getStartingTime();
        //时间格式调整  当天数据
        if (org.springframework.util.StringUtils.hasLength(startingTime)) {
            //设置开始时间
            reqDto.setStartingTime(DateUtils.parseDate(startingTime + " 00:00:00", DateUtils.DATETIMEYYYYMMDD_HHMMSS));
        }
        if (org.springframework.util.StringUtils.hasLength(startingTime)) {
            //设置结束时间
            reqDto.setCompletionTime(DateUtils.parseDate(startingTime + " 24:00:00", DateUtils.DATETIMEYYYYMMDD_HHMMSS));
        }
        //查询列表数据
        List<Achievement> rspDtos = achievementMapper.getAllPage(reqDto);

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }
}
