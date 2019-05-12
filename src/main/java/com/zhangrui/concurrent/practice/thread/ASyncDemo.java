package com.zhangrui.concurrent.practice.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

/**
 * 异步线程池
 */
@Service
public class ASyncDemo {

    @Autowired
    TaskExecutor threadPool;

    /**
     * 同步执行
     * @param user
     */
    public void register(User user) {
        doRegister(user);
        doSyncOrder(user);
    }

    /**
     * 没必要等待增值系统返回处理结果，可以异步执行
     * @param user
     */
    public void asyncRegister(User user) {
        doRegister(user);
        asyncOrder(user);
    }

    /**
     * 异步通知增值赠送福利
     * @param user
     */
    private void asyncOrder(final User user) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                doSyncOrder(user);
            }
        });
    }

    /**
     *执行一系列注册操作
     * @param user
     */
    private void doRegister(User user) {
        System.out.println("执行注册操作");
    }

    /**
     * 通知增值赠送福利
     * @param user
     */
    private void doSyncOrder(User user) {
        System.out.println("赠送会员等福利给注册用户:" + user.getPhone());
    }

}
