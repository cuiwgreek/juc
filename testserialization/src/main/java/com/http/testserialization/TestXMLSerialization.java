/**
 * 
 */
package com.http.testserialization;

import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class TestXMLSerialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person person = new Person();
		person.setAddress("hangzhou,china");
		person.setAge(18);
		person.setBirth(new Date());
		person.setName("zhangsan");
		
		//��person�������л�ΪXML
		XStream xStream = new XStream(new DomDriver());
		//����Person��ı���
		xStream.alias("person", Person.class);
		String personXML = xStream.toXML(person);
		
		//��XML�����л���ԭΪperson����
		Person zhangsan = (Person)xStream.fromXML(personXML);
		
		System.out.println(personXML);
		System.out.println(zhangsan.getBirth());

	}

}
