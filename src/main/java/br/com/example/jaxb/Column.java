package br.com.example.jaxb;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Column implements Serializable {
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlValue
	private String value;

	public Column() {
	}

	public Column(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

}
