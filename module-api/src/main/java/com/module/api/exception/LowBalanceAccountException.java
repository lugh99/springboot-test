package com.module.api.exception;

public class LowBalanceAccountException extends Exception {

	private static final long serialVersionUID = -2869719940732429247L;

	// 提供无参数的构造方法
	  public LowBalanceAccountException() { 
	  } 
	 
	  // 提供一个有参数的构造方法，可自动生成
	  public LowBalanceAccountException(String message) { 
	    super(message);// 把参数传递给Throwable的带String参数的构造方法 
	    System.err.println(message);
	  }
}
