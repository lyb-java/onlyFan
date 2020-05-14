
package com.zm.common;

import io.swagger.annotations.Api;
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

	public ZMResult(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public ZMResult(String code) {
		this.code = code;
		if(Message.SUCCESS_CODE.equals(code)){
			this.msg = "操作成功！";
		}else if(Message.FAIL.equals(code)){
			this.msg = "操作失败！";
		}else if(Message.VERITY_FAIL.equals(code)){
			this.msg = "认证失败！";
		}
	}
	public ZMResult(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public ZMResult(String code, T data) {
		this.code = code;
		this.data = data;
	}
	public ZMResult(Exception e) {
		this.code = Message.SYSTEM_ERROR;
		this.msg = e.getMessage();
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
