package cts.rest.shop.media;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class MyBean {
	@XmlElement(name = "king")
	public String name;
	@XmlTransient
	public int age;

	public MyBean() {
	} // JAXB needs this

	public MyBean(String name, int age) {
		this.name = name;
		this.age = age;
	}
}