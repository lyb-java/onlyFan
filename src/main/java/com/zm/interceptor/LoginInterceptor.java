package com.zm.interceptor;

import com.zm.common.Message;
import com.zm.common.ZMResult;
import com.zm.util.JwtUtil;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 登陆拦截器
 *
 * @author liyangbin
 * @date 2020-1-13
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(LoginInterceptor.class);
    private List<String> exceptUrls;

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        logger.info("==========LoginInterceptor: "+uri);

        String token = request.getHeader("Authorization");
        if(uri.startsWith(request.getContextPath())){
            uri = uri.substring(request.getContextPath().length(), uri.length());
        }
        //放行exceptUrls中配置的url
        for (String url:exceptUrls) {
            if(url.endsWith("/**")){
                if (uri.startsWith(url.substring(0, url.length() - 3))) {
                    logger.info("==========LoginInterceptor===放行:"+uri);
                    return true;
                }
            } else if (uri.startsWith(url)) {
                //登录接口可进且token为空
                if (uri.contains("/index/login")&& token==null ) {
                    return true;
                }else{
                    //token  不为空，解析校验，  直接可访问
                    if(token!=null && JwtUtil.verifyToken(token) > 0){
                        return true;
                    }
                }
                logger.info("==========LoginInterceptor===放行:"+uri);
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(new ZMResult<>(Message.VERITY_FAIL)));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
