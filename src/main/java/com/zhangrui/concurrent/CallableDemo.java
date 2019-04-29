package com.zhangrui.concurrent;

import java.util.concurrent.*;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-04-29-16:34
 * @Description:
 * @Modified: By
 */
public class CallableDemo implements Callable {

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName() + "CallableDemo 执行完了！！！";
	}

	public static void main(String[] args)
		throws ExecutionException, InterruptedException {
		CallableDemo demo = new CallableDemo();
		CallableDemo1 demo1 = new CallableDemo1();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future1 = executorService.submit(demo1);
		Future<String> future = executorService.submit(demo);
		System.out.println(future.get());
		System.out.println(future1.get());
		executorService.shutdown();
	}
}
