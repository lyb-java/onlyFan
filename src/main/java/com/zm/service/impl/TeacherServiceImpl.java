package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.PageViewDto;
import com.zm.dto.StudentReqDto;
import com.zm.dto.TeacherReqDto;
import com.zm.entity.Student;
import com.zm.entity.Teacher;
import com.zm.exception.ValidateException;
import com.zm.mapper.TeacherMapper;
import com.zm.service.TeacherService;
import com.zm.util.AssembleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 教师信息表(Teacher)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(Integer id) {
        return this.teacherMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *@param userInfo 实例对象
     * @param reqDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insert(TeacherReqDto reqDto, AccountDetailsDto userInfo) throws Exception {
        //赋值
        Teacher c = (Teacher) AssembleEntity.assembleEntityByClass(reqDto,Class.class,userInfo);
        Integer result = this.teacherMapper.insert(c);
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
    public Integer update(Teacher c) throws ValidateException {
        Teacher rspDto =  this.queryById(c.getTeacherId());
        if(Objects.isNull(rspDto)){
            throw  new ValidateException("信息不存在！");
        }
        Integer result =this.teacherMapper.updateByPrimaryKeySelective(c);
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
        return this.teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Teacher> getAllPage(PageViewDto<TeacherReqDto> pageViewDto) {
        //分页参数
        Page<Teacher> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<Teacher> rspDtos = teacherMapper.getAllPage(pageViewDto.getCondition());

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }

    @Override
    public List<Teacher> getAllOption() {
        return teacherMapper.getAllOption();
    }
}
