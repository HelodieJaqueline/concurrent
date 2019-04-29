package com.zhangrui.concurrent;

import java.util.concurrent.*;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-04-29-16:34
 * @Description:
 * @Modified: By
 */
public class CallableDemo1 implements Callable {

	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(5);
		return Thread.currentThread().getName() + "CallableDemo1 执行完了！！！";
	}
}
