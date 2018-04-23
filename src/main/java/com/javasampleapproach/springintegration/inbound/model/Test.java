package com.javasampleapproach.springintegration.inbound.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Test")
public class Test {

	private String result="RESULT";

	//@XmlElement
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
