package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.PageViewDto;
import com.zm.dto.StudentReqDto;
import com.zm.entity.Student;
import com.zm.exception.ValidateException;
import com.zm.mapper.StudentMapper;
import com.zm.service.StudentService;
import com.zm.util.AssembleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 学生信息表(Student)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *@param userInfo 实例对象
     * @param reqDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insert(StudentReqDto reqDto, AccountDetailsDto userInfo) throws Exception {
        //赋值
        Student c = (Student) AssembleEntity.assembleEntityByClass(reqDto,Class.class,userInfo);
        Integer result = this.studentMapper.insert(c);
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
    public Integer update(Student c) throws ValidateException {
        Student rspDto =  this.queryById(c.getStudentId());
        if(Objects.isNull(rspDto)){
            throw  new ValidateException("信息不存在！");
        }
        Integer result =this.studentMapper.updateByPrimaryKeySelective(c);
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
        return this.studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Student> getAllPage(PageViewDto<StudentReqDto> pageViewDto) {
        //分页参数
        Page<Student> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<Student> rspDtos = studentMapper.getAllPage(pageViewDto.getCondition());

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }

    @Override
    public List<Student> getAllOption() {
        return studentMapper.getAllOption();
    }
}
