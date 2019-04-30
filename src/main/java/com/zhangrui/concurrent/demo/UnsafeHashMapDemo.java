package com.zhangrui.concurrent.demo;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: ZhangRui
 * @Date: Created at 2019-04-30-16:34
 * @Description:
 * @Modified: By
 */
public class UnsafeHashMapDemo {
	public static void main(String[] args) throws InterruptedException {
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf" + i).start();
				}
			}
		}, "ftf");
		t.start();
		t.join();
	}
}
