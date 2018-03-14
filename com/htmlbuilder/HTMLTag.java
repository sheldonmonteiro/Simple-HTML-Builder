package com.htmlbuilder;

import java.util.ArrayList;

public class HTMLTag {
	private String tagName;
	private ArrayList<HTMLAttribute> attributes = new ArrayList<HTMLAttribute>();
	private ArrayList<HTMLTag> tags = new ArrayList<HTMLTag>();
	
	public HTMLTag(String name) {
		this.tagName = name;
	}

	public void addChild(HTMLTag tag) {
		tags.add(tag);
	}
	
	public void addAttribute(HTMLAttribute attribute) {
		attributes.add(attribute);
	}
	
	public void addAttributes(ArrayList<HTMLAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		//open tag
		stringBuilder.append("<").append(tagName);
		//add attributes
		for(HTMLAttribute attribute : attributes) {
			stringBuilder.append(" ").append(attribute.getAttributeName());
			if(attribute.getAttributeValue() != null) {
				stringBuilder.append("=\"").append(attribute.getAttributeValue()).append("\"");
			}
		}
		stringBuilder.append(">");
		//append child tags
		for(HTMLTag tag : tags) {
			stringBuilder.append(tag.toString());
		}
		//close tag
		stringBuilder.append("</").append(tagName).append(">");
		return stringBuilder.toString();
	}
}
