package br.com.example.jaxb;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "myEntity")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyEntity implements Serializable {
	
	@XmlAttribute(name = "id")
	private String id;
	
	@XmlElement(name = "name")
	private String name;

	@XmlElement(name="Column")
	private List<Column> columns;

	public MyEntity() {
	}

	public MyEntity(String id, String name, List<Column> columns) {
		super();
		this.id = id;
		this.name = name;
		this.columns = columns;
	}
	
}
