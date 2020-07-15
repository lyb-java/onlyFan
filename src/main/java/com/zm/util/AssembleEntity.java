package com.zm.util;

import com.zm.auth.AccountDetailsDto;
import org.springframework.beans.BeanUtils;

/**
 * @author Machenike
 */
public class AssembleEntity {

    public static Object assembleEntityByClass(Object source, Class targetClass, AccountDetailsDto userInfo)throws Exception{
        Object target = targetClass.newInstance();
        //当前时间
        Long time = DateUtils.getCurrentTimes();
        BeanUtils.copyProperties(source,target);
        targetClass.getMethod("setOpRoleName",Integer.class).invoke(target,userInfo.getRoleName());
        targetClass.getMethod("setOpUserId",Integer.class).invoke(target,userInfo.getId());
        targetClass.getMethod("setOpUserName",String.class).invoke(target,userInfo.getUserName());
        targetClass.getMethod("setCreateTime",Long.class).invoke(target, time);
        targetClass.getMethod("setUpdateTime",Long.class).invoke(target, time);
        targetClass.getMethod("setIsDelete",String.class).invoke(target,"0");
        return target;
    }

}
