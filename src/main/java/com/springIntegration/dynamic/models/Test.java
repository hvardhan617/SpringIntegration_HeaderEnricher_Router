package com.springIntegration.dynamic.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Test")
public class Test {

	private String result="RESULT";

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
