package com.zm.common;


/**
 * 错误码定义类
 * @author liyangbin
 * @description
 * @date 2020-1-14下午3:27:01
 */
public enum Message {

	SUCCESS("000000", "操作成功"),

	OPERATION_FAILURE("000001", "操作失败"),

	FAILURE("000002", "未知异常"),

	AUTHENTICATION_FAILURE("000003", "认证失败");


	private String retcode;

	private String retmsg;

	private Message(String retcode, String retmsg) {
		this.retcode = retcode;
		this.retmsg = retmsg;
	}

	@Override
	public String toString() {
		return this.retcode + "_" + this.retmsg;
	}

	public String getRetcode() {
		return retcode;
	}


	public String getRetmsg() {
		return retmsg;
	}
}
