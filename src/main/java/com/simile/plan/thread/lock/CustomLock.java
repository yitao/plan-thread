package com.simile.plan.thread.lock;

/**
 * 锁接口
 * Created by yitao on 2019/1/14.
 */
public interface CustomLock {

    void lock()throws InterruptedException ;

    void unlock();

}
