package com.simile.plan.thread.lock;

/**
 * 自定义可重入锁
 * Created by yitao on 2019/1/14.
 */
public class CustomReentrantLockImpl implements CustomLock {
    private boolean locked = false;     //是否锁住
    private Thread lockedThread = null; //锁住的线程
    private int lockedCount = 0;        //锁住的次数

    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (locked && lockedThread != thread) {
            wait();
        }
        locked = true;
        lockedCount++;
        lockedThread = thread;
    }

    public synchronized void unlock() {
        Thread thread = Thread.currentThread();
        if (lockedThread == thread) {
            lockedCount--;
            if (lockedCount == 0) {
                locked = false;
                notify();
            }
        }
    }


    @Override
    public String toString() {
        return this.locked + ":" + this.lockedCount;
    }
}
