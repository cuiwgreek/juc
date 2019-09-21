package com.cuiwjava.threadx;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname MyThread
 * @Description TODO
 * @Date 2019/9/21/021 23:04
 * @Created by cuiwjava
 */
public class MyThread implements Callable<String> {

    private int ticket = 10;
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */

    public String call() throws Exception {
        for (int x = 0; x < 100; x ++){
            if (this.ticket > 0){
                System.out.println("买票,ticket = " + this.ticket);
            }
        }
        return "票已卖光";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        FutureTask<String> task1 = new FutureTask(mt1);
        FutureTask<String> task2 = new FutureTask(mt1);
        // 目的是为了取得call()的返回值
        new Thread(task1).start();
        new Thread(task2).start();
        System.out.println("A线程的返回结果: " + task1.get());
        System.out.println("B线程的返回结果: " + task2.get());

    }
}
