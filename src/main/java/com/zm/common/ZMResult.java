
package com.zm.common;

import com.zm.exception.BusinessException;
import com.zm.exception.ValidateException;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description 返回结果封装类
 * @author liyangbin
 * @date 2020年1月7日下午6:20:41
 */
public class ZMResult<T> {
	@ApiModelProperty(value = "响应码")
	private String code;
	@ApiModelProperty(value = "响应话术")
	private String msg;
	@ApiModelProperty(value = "响应对象数据")
	private T data;

	public ZMResult() {
	}

	public ZMResult(Message constant){
		this.code = constant.getRetcode();
		this.msg = constant.getRetmsg();
	}
	public ZMResult(Message message, T data) {
		this.code = message.getRetcode();
		this.msg = message.getRetmsg();
		this.data = data;

	}
	public ZMResult(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public ZMResult(Exception e) {
		this.code = Message.OPERATION_FAILURE.getRetcode();
		this.msg = e.getMessage();
		if (e instanceof BusinessException) {
			this.code = "500000";
		} else if (e instanceof ValidateException) {

		} else {
			this.code = Message.FAILURE.getRetcode();
			this.msg = Message.FAILURE.getRetmsg();
		}
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
