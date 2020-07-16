package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.CourseReqDto;
import com.zm.dto.PageViewDto;
import com.zm.entity.Course;
import com.zm.exception.ValidateException;
import com.zm.mapper.CourseMapper;
import com.zm.service.CourseService;
import com.zm.util.AssembleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 课程安排信息表(ZmCourse)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Course queryById(Integer id) {
        return this.courseMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *@param userInfo 实例对象
     * @param reqDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insert(CourseReqDto reqDto, AccountDetailsDto userInfo) throws Exception {
        //赋值
        Course c = (Course) AssembleEntity.assembleEntityByClass(reqDto,Class.class,userInfo);
        Integer result = this.courseMapper.insert(c);
        return result;
    }

    /**
     * 修改数据
     *
     * @param c 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer update(Course c) throws ValidateException {
        Course rspDto =  this.queryById(c.getClassId());
        if(Objects.isNull(rspDto)){
            throw  new ValidateException("信息不存在！");
        }
        Integer result =this.courseMapper.updateByPrimaryKeySelective(c);
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Course> getAllPage(PageViewDto<CourseReqDto> pageViewDto) {
        //分页参数
        Page<Course> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<Course> rspDtos = courseMapper.getAllPage(pageViewDto.getCondition());

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }
}
