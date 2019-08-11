/**
 * 
 */
package com.http.testserialization;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;



public class TestJSONSerialization {

	public static void main(String[] args) throws IOException{
		
		
		Person person = new Person();
		person.setAddress("hangzhou,china");
		person.setAge(18);
		person.setBirth(new Date());
		person.setName("zhangsan");
		
		//json�������л�
		String personJson = null;
		ObjectMapper mapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
		mapper.writeValue(gen, person);
		gen.close();
		personJson = sw.toString();
		
		//json�������л�
		Person zhangsan = (Person)mapper.readValue(personJson, Person.class);
		
		System.out.println(personJson);
		System.out.println(zhangsan.getName());
		
	}
}
