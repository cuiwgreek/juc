package com.cuiwjava.sequence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicIntegerTest
 * @Description TODO
 * @Date 2019/11/30 18:04
 * @Created by cuiwei34
 */
public class AtomicIntegerTest {

	static AtomicInteger threadNo = new AtomicInteger(1);

	public static void main(String[] args) {

		char[] a1 = "123456".toCharArray();
		char[] c1 = "ABCDEF".toCharArray();

		new Thread(() -> {
			for (char c:
			     a1) {
				while (threadNo.get() != 1){}
					System.out.print(c + " ");
					threadNo.set(2);
				}
		}, "t1").start();

		new Thread(() -> {
			for (char c:
			     c1) {
				while (threadNo.get() !=2){}
				System.out.print(c + " ");
				threadNo.set(1);
			}
		}, "t2").start();
	}
}
