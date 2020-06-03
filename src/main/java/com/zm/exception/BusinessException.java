package com.zm.exception;

/**
 * @Author: liyangbin
 * @Desc:
 * @Date: Created in 22:18 2020-5-29
 * @Modified By:
 */
public class BusinessException extends Exception {
    private String code;//错误码
    private String msg;//错误信息
    public BusinessException() {
        super();
    }
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String code,String message) {
        super(message);
        this.code=code;
        this.msg=message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
