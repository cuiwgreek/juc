package com.cuiwjava.lockx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock extends Thread {
	private Lock lock = new ReentrantLock();

	public void get() {
		lock.lock();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getId() + ",get");
		set();
		lock.unlock();
	}

	public void set() {
		lock.lock();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getId() + ",set");
		lock.unlock();

	}

	@Override
	public void run() {
		get();
	}

	public static void main(String[] args) {
		TestLock ss = new TestLock();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
	}

}
