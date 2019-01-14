package com.simile.plan.thread.lock;

/**
 * 自定义不可重入锁（自旋锁）
 * 按照字面理解，该锁不可以重复进入。
 * <p>
 * Created by yitao on 2019/1/14.
 */
public class CustomLockImpl implements CustomLock {
    private boolean locked = false; //是否锁住了

    public synchronized void lock() throws InterruptedException {
        while (locked) {
            wait();
        }
        locked = true;
    }

    public synchronized void unlock() {
        locked = false;
        notify();
    }

}
