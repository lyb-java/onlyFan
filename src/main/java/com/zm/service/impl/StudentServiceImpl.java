package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.PageViewDto;
import com.zm.dto.StudentReqDto;
import com.zm.dto.StudentRspDto;
import com.zm.entity.ClassRelationStudent;
import com.zm.entity.Student;
import com.zm.exception.ValidateException;
import com.zm.mapper.ClassRelationStudentMapper;
import com.zm.mapper.StudentMapper;
import com.zm.service.StudentService;
import com.zm.util.AssembleEntity;
import com.zm.util.DateUtils;
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
    @Resource
    private ClassRelationStudentMapper classRelationStudentMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StudentRspDto queryById(Integer id) {
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
        Student student = studentMapper.selectByStudent(reqDto);
        if(Objects.nonNull(student)){
            throw  new ValidateException("该学生已存在！");
        }
        Student stu = (Student) AssembleEntity.assembleEntityByClass(reqDto,Student.class,userInfo);
        //添加学生
        int result = this.studentMapper.insert(stu);
        //添加学生关联班级
        ClassRelationStudent classRelationStudent = new ClassRelationStudent();
        classRelationStudent.setClassId(reqDto.getClassId());
        classRelationStudent.setStudentId(stu.getStudentId());
        classRelationStudent.setCreateTime(DateUtils.getCurrentTimes());
        classRelationStudent.setUpdateTime(DateUtils.getCurrentTimes());
        classRelationStudent.setIsDelete("0");
        result+=classRelationStudentMapper.insert(classRelationStudent);

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
    public Integer update(StudentReqDto reqDto) throws ValidateException {
        Student rspDto =  this.queryById(reqDto.getStudentId());
        if(Objects.isNull(rspDto)){
            throw  new ValidateException("信息不存在！");
        }
        Integer result =this.studentMapper.updateByPrimaryKeySelective(reqDto);
        //修改学生关联班级表
        ClassRelationStudent classRelationStudent = new ClassRelationStudent();
        classRelationStudent.setClassId(reqDto.getClassId());
        classRelationStudent.setStudentId(reqDto.getStudentId());
        classRelationStudent.setUpdateTime(DateUtils.getCurrentTimes());
        result+=classRelationStudentMapper.updateByStudentId(classRelationStudent);
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
        //删除学生
        Integer result = this.studentMapper.deleteByPrimaryKey(id);
        //删除学生关联班级
        result += this.classRelationStudentMapper.deleteByStudentId(id);
        return result;
    }

    @Override
    public PageInfo<StudentRspDto> getAllPage(PageViewDto<StudentReqDto> pageViewDto) {
        //分页参数
        Page<StudentRspDto> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<StudentRspDto> rspDtos = studentMapper.getAllPage(pageViewDto.getCondition());

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }

    @Override
    public List<Student> getAllOption() {
        return studentMapper.getAllOption();
    }

    @Override
    public List<Student> getOptionNoUserId() {
        return studentMapper.getOptionNoUserId();
    }
}
