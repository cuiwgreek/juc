package com.cuiwjava.sequence;

import java.util.concurrent.CountDownLatch;

/**
 * @Classname SyncWaitNotifyTest
 * @Description TODO
 * @Date 2019/11/30 19:19
 * @Created by cuiwei34
 */
public class SyncWaitNotifyTest {

	final static Object o = new Object();

	static CountDownLatch latch = new CountDownLatch(1);

	static volatile boolean t2Started = false;

	public static void main(String[] args) throws InterruptedException {

		char[] a1 = "1234567".toCharArray();
		char[] c1 = "ABCDEFG".toCharArray();

		new Thread(()->{
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (o){

//				while (!t2Started){
//					try {
//						o.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
				for (char c: c1
				) {
					System.out.print(c + " ");

					try {
						o.notify();
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				o.notify();// 最后让程序直接结束 必须的
			}
		},"t2").start();

		new Thread(()->{
			synchronized (o){
//				t2Started = true;

				for (char c: a1
				) {
					System.out.print(c + " ");
					latch.countDown();
					try {
						o.notify();
						// 叫醒除去自己以外其他线程
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 自己让出锁
				}
				o.notify();
			}
		},"t1").start();



	}
}
