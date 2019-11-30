package com.cuiwjava.sequence;

/**
 * @Classname TestLockSupport
 * @Description TODO
 * @Date 2019/11/30 15:55
 * @Created by cuiwei34
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * 用两个线程,一个输出字母,一个输出数字, 交替输出1A2B3C4D...26Z
 */
public class TestLockSupport {

	static Thread t1 = null , t2 = null;
	public static void main(String[] args) {
		char[] a1 = "1234567".toCharArray();
		char[] c1 = "ABCDEFG".toCharArray();

		t1 = new Thread(() -> {
			for (char c : a1) {
				System.out.print(c +" ");
				LockSupport.unpark(t2);
				LockSupport.park();
			}
		});

		t2 = new Thread(()->{
			for (char c : c1){
				LockSupport.park();
				System.out.print(c + " ");
				LockSupport.unpark(t1);
			}
		});

		t1.start();
		t2.start();

	}
}
