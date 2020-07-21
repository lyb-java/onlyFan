package com.zm.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.CourseReqDto;
import com.zm.dto.PageViewDto;
import com.zm.entity.Course;
import com.zm.entity.Class;
import com.zm.entity.Teacher;
import com.zm.exception.ValidateException;
import com.zm.mapper.ClassMapper;
import com.zm.mapper.CourseMapper;
import com.zm.mapper.TeacherMapper;
import com.zm.service.CourseService;
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
 * 课程安排信息表(ZmCourse)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private ClassMapper classMapper;
    @Resource
    private TeacherMapper teacherMapper;
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
        Course course = (Course) AssembleEntity.assembleEntityByClass(reqDto,Course.class,userInfo);
        //查询班级
        Class cla = classMapper.selectByPrimaryKey(reqDto.getClassId());
        //查询教师
        Teacher teacher = teacherMapper.selectByPrimaryKey(reqDto.getTeacherId());
        //班级名称 教师名称
        course.setClassName(cla.getName());
        course.setTeacherName(teacher.getName());
        //时间格式化 上课起始时间
        String starTime = DateUtils.parseDate(reqDto.getCourseStartTime(),DateUtils.DATETIMEYYYYMMDD_HHMM);
        String endTime = DateUtils.parseDate(reqDto.getCourseEndTime(),DateUtils.DATETIMEYYYYMMDD_HHMM);
        course.setStartTime(Long.parseLong(starTime));
        course.setEndTime(Long.parseLong(endTime));
        Integer result = this.courseMapper.insert(course);
        return result;
    }

    /**
     * 修改数据
     *
     * @param reqDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer update(CourseReqDto reqDto) throws ValidateException {
        Course course =  this.queryById(reqDto.getCourseId());
        if(Objects.isNull(course)){
            throw  new ValidateException("信息不存在！");
        }
        BeanUtils.copyProperties(reqDto,course);
        //查询班级
        Class cla = classMapper.selectByPrimaryKey(reqDto.getClassId());
        //查询教师
        Teacher teacher = teacherMapper.selectByPrimaryKey(reqDto.getTeacherId());
        //班级名称 教师名称
        course.setClassName(cla.getName());
        course.setTeacherName(teacher.getName());
        //时间格式化 上课起始时间
        String courseStartTime= DateUtils.UTCDateFormat(reqDto.getCourseStartTime());
        String courseEndTime= DateUtils.UTCDateFormat(reqDto.getCourseEndTime());

        String starTime = DateUtils.parseDate(courseStartTime,DateUtils.DATETIMEYYYYMMDD_HHMM);
        String endTime = DateUtils.parseDate(courseEndTime,DateUtils.DATETIMEYYYYMMDD_HHMM);
        course.setStartTime(Long.parseLong(starTime));
        course.setEndTime(Long.parseLong(endTime));

        Integer result = this.courseMapper.updateByPrimaryKeySelective(course);
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
    public PageInfo<Course> getAllPage(PageViewDto<CourseReqDto> pageViewDto) throws ValidateException {
        CourseReqDto reqDto = new CourseReqDto();
        //分页参数
        Page<Course> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());

        BeanUtils.copyProperties(pageViewDto.getCondition(), reqDto);
        String courseStartTime= reqDto.getCourseStartTime();
        //时间格式调整  当天数据
        if (org.springframework.util.StringUtils.hasLength(courseStartTime)) {
            //设置开始时间
            reqDto.setCourseStartTime(DateUtils.parseDate(courseStartTime + " 00:00:00", DateUtils.DATETIMEYYYYMMDD_HHMMSS));
        }
        if (org.springframework.util.StringUtils.hasLength(courseStartTime)) {
            //设置结束时间
            reqDto.setCourseEndTime(DateUtils.parseDate(courseStartTime + " 24:00:00", DateUtils.DATETIMEYYYYMMDD_HHMMSS));
        }
        //查询列表数据
        List<Course> rspDtos = courseMapper.getAllPage(reqDto);
        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }
}
