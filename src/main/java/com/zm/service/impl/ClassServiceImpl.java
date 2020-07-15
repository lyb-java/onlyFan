package com.zm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.auth.AccountDetailsDto;
import com.zm.dto.AchievementReqDto;
import com.zm.dto.ClassReqDto;
import com.zm.dto.PageViewDto;
import com.zm.entity.Achievement;
import com.zm.entity.Class;
import com.zm.exception.ValidateException;
import com.zm.mapper.ClassMapper;
import com.zm.service.ClassService;
import com.zm.util.AssembleEntity;
import org.springframework.stereotype.Service;

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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Class queryById(Integer id) {
        return this.classMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *@param userInfo 实例对象
     * @param reqDto 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(ClassReqDto reqDto, AccountDetailsDto userInfo) throws Exception {
        //赋值
        Class c = (Class) AssembleEntity.assembleEntityByClass(reqDto,Class.class,userInfo);
        Integer result = this.classMapper.insert(c);
        return result;
    }

    /**
     * 修改数据
     *
     * @param c 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(Class c) throws ValidateException {
        Class rspDto =  this.queryById(c.getId());
        if(Objects.isNull(rspDto)){
            throw  new ValidateException("班级信息不存在！");
        }
        Integer result =this.classMapper.updateByPrimaryKeySelective(c);
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
        return this.classMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Class> getAllPage(PageViewDto<ClassReqDto> pageViewDto) {
        //分页参数
        Page<Class> page = PageHelper.startPage(pageViewDto.getPageIndex(), pageViewDto.getPageSize());
        //查询列表数据
        List<Class> rspDtos = classMapper.getAllPage(pageViewDto.getCondition());

        PageInfo  pageInfo = page.toPageInfo();
        pageInfo.setTotal(rspDtos.size());
        pageInfo.setList(rspDtos);
        return pageInfo;
    }
}
