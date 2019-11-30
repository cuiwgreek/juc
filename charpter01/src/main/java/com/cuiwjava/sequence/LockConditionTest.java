package com.cuiwjava.sequence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname LockConditionTest
 * @Description TODO
 * @Date 2019/11/30 21:09
 * @Created by cuiwei34
 */
public class LockConditionTest {
	public static void main(String[] args) {
		char[] a1 = "1234567".toCharArray();
		char[] c1 = "ABCDEFG".toCharArray();

		ReentrantLock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();

		new Thread(()->{

			try {
				lock.lock();
				for (char c:a1) {
					System.out.print(c + " ");
					condition2.signal();
					// 通知等待哪些线程
					condition1.await();
				}
				condition2.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		},"t1").start();

		new Thread(()->{
			try {
				lock.lock();
				for (char c:c1) {
					System.out.print(c + " ");
					condition1.signal();
					condition2.await();
				}
				condition1.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}


		},"t2").start();
		
	}
}
