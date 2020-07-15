package com.zm.controller;

import com.zm.auth.AccountDetailsDto;
import com.zm.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liyangbin
 * @Desc:
 * @Date: Created in 19:51 2020-7-15
 * @Modified By:
 */
@ApiIgnore
public class BaseController {

    public final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取用户信息
     * @return
     */
    public AccountDetailsDto getUserInfo() {
        return (AccountDetailsDto) this.getServletRequest()
                .getAttribute(Constant.REQ_ATTR_TOKEN);
    }
    protected HttpServletRequest getServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
