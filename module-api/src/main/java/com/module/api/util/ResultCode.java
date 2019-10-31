package com.module.api.util;

public class ResultCode {
	// 成功状态码
	public static final int SUCCESS = 1;

	// -------------------失败状态码----------------------
	// 参数错误
	public static final int PARAMS_IS_NULL = 10001;// 参数为空
	public static final int PARAMS_NOT_COMPLETE = 10002; // 参数不全
	public static final int PARAMS_TYPE_ERROR = 1003; // 参数类型错误
	public static final int PARAMS_IS_INVALID = 10004; // 参数无效

	// 资金账户错误
	public static final int NULL_ACCOUNT = 20001; // 账户不存在
	public static final int LOW_BALANCE = 20002; // 余额不足

	// 系统错误
	public static final int SYSTEM_ERROR = 40001; // 系统错误
}
