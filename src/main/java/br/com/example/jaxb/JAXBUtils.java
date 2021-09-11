package br.com.example.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXB;

public class JAXBUtils {
	
	public static void main(String[] args) {
		
		ArrayList<Column> columns = new ArrayList<>();
		columns.add(new Column("date_deployed1", "2016-01-01"));
		columns.add(new Column("date_deployed2", "2016-01-02"));
		columns.add(new Column("date_deployed3", "2016-01-03"));
		
		// Entity to XML
		MyEntity myEntity = new MyEntity("1", "Alex", columns);
		String str = marshal(myEntity);
		System.out.println(str);
		
		// XML to Entity
		MyEntity myEntity2 = unmarshal(str, MyEntity.class);
		System.out.println(myEntity2); // To a better output override the entity to string
	}

	public static <T> T unmarshal(String xml, Class<T> type) {
		StringReader reader = new StringReader(xml);
		return javax.xml.bind.JAXB.unmarshal(reader, type);
	}

	public static String marshal(Object object) {
		StringWriter stringWriter = new StringWriter();
		JAXB.marshal(object, stringWriter);
		return stringWriter.toString();
	}
}