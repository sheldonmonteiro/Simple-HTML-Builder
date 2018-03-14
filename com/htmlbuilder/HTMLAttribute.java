package com.htmlbuilder;

public class HTMLAttribute {
	private String attributeName;
	private String attributeValue;
	
	public HTMLAttribute(String attributeName) {
		this.attributeName = attributeName;
	}
	
	public HTMLAttribute(String attributeName, String attributeValue) {
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
}
