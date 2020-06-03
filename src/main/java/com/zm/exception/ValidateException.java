package com.zm.exception;

/**
 *
 * @Author: liyangbin
 * @Desc: 后台校验异常
 * @Date: Created in 22:18 2020-5-29
 * @Modified By:
 */
public class ValidateException extends Exception {

	private String code;//错误码
	
    private String msg;//错误信息
    
    public ValidateException() {
        super();
    }
    public ValidateException(String message) {
        super(message);
    }
    public ValidateException(String code,String message) {
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
