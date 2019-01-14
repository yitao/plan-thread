package com.simile.plan.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 系统可重入锁任务实现
 * Created by yitao on 2019/1/14.
 */
public class ReentrantLockTaskServiceImpl implements TaskService {

    private ReentrantLock lock = new ReentrantLock();

    public void doJob1(String param) {
        lock.lock();
        System.out.println("系统可重入锁任务实现，任务1:" + param);
        doJob2(param);
        lock.unlock();
    }

    public void doJob2(String param) {
        lock.lock();
        System.out.println("系统可重入锁任务实现，任务2:" + param);
        lock.unlock();
    }

}
