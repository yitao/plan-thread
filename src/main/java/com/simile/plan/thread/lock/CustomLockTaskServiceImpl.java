package com.simile.plan.thread.lock;

/**
 * 自定义不可重入锁任务实现
 * Created by yitao on 2019/1/14.
 */
public class CustomLockTaskServiceImpl implements TaskService {

    private CustomLock lock = new CustomLockImpl();

    public void doJob1(String param) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("不可重入锁任务实现，任务1:" + param);
        doJob2(param);
        lock.unlock();
    }

    public void doJob2(String param) {
        try {
            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("不可重入锁任务实现，任务2:" + param);
        lock.unlock();
    }

}
