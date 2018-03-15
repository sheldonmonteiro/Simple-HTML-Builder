package com.htmlbuilder;

import java.util.ArrayList;

public class HTMLTag {
	private String tagName;
	private ArrayList<HTMLAttribute> attributes = new ArrayList<HTMLAttribute>();
	private String innerHTML;
	private ArrayList<HTMLTag> childTags = new ArrayList<HTMLTag>();
	
	public HTMLTag(String name) {
		this.tagName = name;
	}
	
	public HTMLTag(String name, ArrayList<HTMLAttribute> attributes) {
		this.tagName = name;
		this.attributes = attributes;
	}
	
	public HTMLTag(String name, ArrayList<HTMLAttribute> attributes, ArrayList<HTMLTag> childTags) {
		this.tagName = name;
		this.attributes = attributes;
		this.childTags = childTags;
	}
	
	public HTMLTag(String name, ArrayList<HTMLAttribute> attributes, String innerHTML, ArrayList<HTMLTag> childTags) {
		this.tagName = name;
		this.attributes = attributes;
		this.childTags = childTags;
		this.innerHTML = innerHTML;
	}

	public void addChildTag(HTMLTag tag) {
		childTags.add(tag);
	}
	
	public void setChildTags(ArrayList<HTMLTag> tag) {
		this.childTags = tag;
	}
	
	public void addAttribute(HTMLAttribute attribute) {
		attributes.add(attribute);
	}
	
	public void setAttributes(ArrayList<HTMLAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder = addOpeningTag(stringBuilder);
		stringBuilder.append(innerHTML);
		stringBuilder = addChildTags(stringBuilder);
		stringBuilder.append("</").append(tagName).append(">");
		return stringBuilder.toString();
	}
	
	private StringBuilder addOpeningTag(StringBuilder stringBuilder) {
		stringBuilder.append("<").append(tagName);
		stringBuilder = addAttributes(stringBuilder);
		stringBuilder.append(">");
		
		return stringBuilder;
	}
	
	private StringBuilder addAttributes(StringBuilder stringBuilder) {
		for(HTMLAttribute attribute : attributes) {
			stringBuilder.append(" ").append(attribute.getAttributeName());
			if(attribute.getAttributeValue() != null) {
				stringBuilder.append("=\"").append(attribute.getAttributeValue()).append("\"");
			}
		}
		
		return stringBuilder;
	}
	
	private StringBuilder addChildTags(StringBuilder stringBuilder) {
		for(HTMLTag tag : childTags) {
			stringBuilder.append(tag.toString());
		}
		return stringBuilder;
	}
}
