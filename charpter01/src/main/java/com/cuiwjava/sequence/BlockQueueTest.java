package com.cuiwjava.sequence;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Classname BlockQueueTest
 * @Description TODO
 * @Date 2019/11/30 18:14
 * @Created by cuiwei34
 */
public class BlockQueueTest {
	static BlockingQueue<String> q1 =  new ArrayBlockingQueue<String>(1);
	static BlockingQueue<String> q2 =  new ArrayBlockingQueue<String>(1);
	// 线程安全
	public static void main(String[] args) {
		char[] a1 = "1234567".toCharArray();
		char[] c1 = "ABCDEFG".toCharArray();

		new Thread(()->{
			for (char c:a1
			     ) {
				System.out.print(c + " ");
				try {
					q1.put("ok");
					q2.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		},"t1").start();

		new Thread(()->{
			for (char c: c1
			     ) {
				try {
					q1.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(c + " ");
				try {
					q2.put("ok");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		},"t2");

	}
}
