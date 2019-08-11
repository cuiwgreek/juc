/**
 * 
 */
package com.http.testserialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;


public class TestHessianSerialization {


	public static void main(String[] args) throws IOException {
	
		Person zhansan = new Person();
		zhansan.setAddress("hangzhou");
		zhansan.setAge(30);
		zhansan.setBirth(new Date());
		zhansan.setName("zhansan");
		
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//hessian�����л����
		HessianOutput ho = new HessianOutput(os);
		ho.writeObject(zhansan);
		byte[] zhansanByte = os.toByteArray();
		
		ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);
		//hessian�ķ����л���ȡ����
		HessianInput hi = new HessianInput(is);
		Person person = (Person)hi.readObject();
		
		System.out.println("name : " + person.getName() + ", age : " + person.getAge());
		
	}
	
	

}
