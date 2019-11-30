package com.cuiwjava.sequence;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Classname PipedStreamTest
 * @Description TODO
 * @Date 2019/11/30 18:42
 * @Created by cuiwei34
 * 半双工
 */
public class PipedStreamTest {
	public static void main(String[] args) throws IOException {
		char[] a1 = "1234567".toCharArray();
		char[] c1 = "ABCDEFG".toCharArray();

		PipedInputStream input1 = new PipedInputStream();
		PipedInputStream input2 = new PipedInputStream();
		PipedOutputStream output1 = new PipedOutputStream();
		PipedOutputStream output2 = new PipedOutputStream();

		input1.connect(output2);
		input1.connect(output1);

		String msg = "Your Turn";
		new Thread(()->{
			byte[] buffer = new byte[9];

			for (char c: a1
			     ) {
				try {
					input1.read(buffer);
					if (new String(buffer).equals(msg)) {
						System.out.print(c + " ");
					}
					output1.write(msg.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		},"t1");

		new Thread(()->{
			byte[] buffer = new byte[9];

			for (char c: a1
			) {
				System.out.print(c + " ");
				try {
					output2.write(msg.getBytes());
					input2.read(buffer);

					if (new String(buffer).equals(msg)) {
						continue;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}


			}
		},"t2");
	}
}
