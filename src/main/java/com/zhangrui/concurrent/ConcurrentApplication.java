package com.zhangrui.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class ConcurrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentApplication.class, args);
	}

	@Bean
	public ThreadPoolTaskExecutor threadPool() {
		ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
		int coreSize = Runtime.getRuntime().availableProcessors();
		threadPool.setCorePoolSize(coreSize);
		threadPool.setMaxPoolSize(coreSize << 1);
		threadPool.setQueueCapacity(1000);
		threadPool.setKeepAliveSeconds(60);
		threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return threadPool;
	}
}
