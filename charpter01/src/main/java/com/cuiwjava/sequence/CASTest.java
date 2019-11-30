package com.cuiwjava.sequence;

/**
 * @Classname CASTest
 * @Description TODO
 * @Date 2019/11/30 17:51
 * @Created by cuiwei34
 *
 * 偏向锁 -> 自旋锁 -> 重量级锁
 */
public class CASTest {
	enum ReadyToRun{ T1, T2}
	static volatile ReadyToRun r = ReadyToRun.T1;

	public static void main(String[] args) {
		char[] a1 = "1234567".toCharArray();
		char[] c1 = "ABCDEFG".toCharArray();

		new Thread(()->{
			for (char c : a1) {
				while (r != ReadyToRun.T1){}
				System.out.print(c + " ");
				r = ReadyToRun.T2;
			}
		},"t1").start();

		new Thread(()->{
			for (char c: c1
			     ) {
				while (r != ReadyToRun.T2){
//					System.out.println("===");
				}
				System.out.print(c + " ");
				r = ReadyToRun.T1;
			}
		},"t2").start();
	}
}
