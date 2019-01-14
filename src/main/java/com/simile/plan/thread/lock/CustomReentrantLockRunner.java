package com.simile.plan.thread.lock;

/**
 * 自定义可重入锁演示
 * Created by yitao on 2019/1/14.
 */
public class CustomReentrantLockRunner {

    public static void main(String[] args) {
        TaskService taskService = new CustomReentrantLockTaskServiceImpl();
        for (int i = 1; i < 4; i++) {
            final int c = i;
            taskService.doJob1("处理订单事件，第" + c + "次");
//            taskService.doJob2("处理订单事件2，第" + c + "次");
//            new Thread(() -> {
//                taskService.doJob1("处理订单事件，第" + c + "次");
//            }).start();
        }
    }

}
