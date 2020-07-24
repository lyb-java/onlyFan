package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.ClassReqDto;
import com.zm.dto.ClassRspDto;
import com.zm.dto.PageViewDto;
import com.zm.entity.Class;
import com.zm.entity.ClassRelationTeacher;
import com.zm.exception.ValidateException;
import com.zm.mapper.ClassMapper;
import com.zm.mapper.ClassRelationStudentMapper;
import com.zm.mapper.ClassRelationTeacherMapper;
import com.zm.service.ClassService;
import com.zm.util.AssembleEntity;
import com.zm.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 班级信息表(Class)表服务实现类
 *
 * @author liyangbin
 * @since 2020-07-15 15:22:34
 */
@Service("ClassService")
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;
    @Resource
    private ClassRelationTeacherMapper classRelationTeacherMapper;
    @Resource
    private ClassRelationStudentMapper classRelationStudentMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ClassRspDto queryById(Integer id) {
        return this.classMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *@param userInfo 实例对象
     * @param reqDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insert(ClassReqDto reqDto, AccountDetailsDto userInfo) throws Exception {
        //教师只能绑定一个班级
        ClassRelationTeacher classRelationTeacher = classRelationTeacherMapper.selectByTeacherId(reqDto.getTeacherId());
        if(Objects.nonNull(classRelationTeacher)){
            throw new ValidateException("此教师已绑定其他班级！");
        }
        //赋值
        Class aClass = (Class) AssembleEntity.assembleEntityByClass(reqDto,Class.class,userInfo);
        //添加班级
        Integer result = this.classMapper.insert(aClass);
        //添加班级关联教师
        ClassRelationTeacher relationTeacher = new ClassRelationTeacher();
        relationTeacher.setClassId(aClass.getClassId());
        relationTeacher.setTeacherId(reqDto.getTeacherId());
        relationTeacher.setCreateTime(DateUtils.getCurrentTimes());
        relationTeacher.setUpdateTime(DateUtils.getCurrentTimes());
        relationTeacher.setIsDelete("0");
        result+=classRelationTeacherMapper.insert(relationTeacher);

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
    public Integer update(ClassReqDto reqDto) throws ValidateException {
        //教师只能绑定一个班级
        ClassRelationTeacher classRelationTeacher = classRelationTeacherMapper.selectByTeacherId(reqDto.getTeacherId());
        if(Objects.nonNull(classRelationTeacher)){
            if(!classRelationTeacher.getClassId().equals(reqDto.getClassId())){
                throw new ValidateException("此教师已绑定其他班级！");
            }
        }
        Class rspDto =  this.queryById(reqDto.getClassId());
        if(Objects.isNull(rspDto)){
            throw  new ValidateException("班级信息不存在！");
        }
        Integer result =this.classMapper.updateByPrimaryKeySelective(reqDto);
        //修改班级关联教师
        ClassRelationTeacher relationTeacher = new ClassRelationTeacher();
        relationTeacher.setTeacherId(reqDto.getTeacherId());
        relationTeacher.setClassId(reqDto.getClassId());
        relationTeacher.setUpdateTime(DateUtils.getCurrentTimes());
        relationTeacher.setIsDelete("0");
        result+=classRelationTeacherMapper.updateByClassId(relationTeacher);

        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) throws ValidateException {
        //班级下有学生不允许删除
        Integer isClass = classRelationStudentMapper.getByClassId(id);
        if(isClass>0){
            throw  new ValidateException("班级下有学生不允许删除!");
        }
        Integer result = this.classMapper.deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public PageInfo<ClassRspDto> getAllPage(PageViewDto<ClassReqDto> pageViewDto,AccountDetailsDto userInfo ) {
        //分页参数
        Page<ClassRspDto> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<ClassRspDto> rspDtos = classMapper.getAllPage(pageViewDto.getCondition(),userInfo);

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }

    @Override
    public List<Class> getAllOption() {
        List<Class> classList = classMapper.getAllOption();
        return classList;
    }
}
