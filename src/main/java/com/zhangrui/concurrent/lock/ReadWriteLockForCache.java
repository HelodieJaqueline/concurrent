package com.zhangrui.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockForCache {
    private static Map<String, Object> cacheMap = new HashMap<String, Object>();

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();

    private static Lock writeLock = readWriteLock.writeLock();


    /**
     * 设置缓存
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        writeLock.lock();
        try {
            cacheMap.put(key, value);
        }finally {
            writeLock.unlock();
        }
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public static Object get(String key) {
        readLock.lock();
        try {
            return cacheMap.get(key);
        }finally {
            readLock.unlock();
        }
    }
}
