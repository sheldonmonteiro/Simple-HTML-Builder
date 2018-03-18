package com.htmlbuilder;

import java.util.ArrayList;

public class HTMLTag {
	private String tagName;
	private ArrayList<HTMLAttribute> attributes = new ArrayList<HTMLAttribute>();
	private String innerHTML = "";
	private ArrayList<HTMLTag> childTags = new ArrayList<HTMLTag>();
	private StringBuilder stringBuilder;
	private int indentLevel;
	
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
	
	public void addAttribute(HTMLAttribute attribute) {
		attributes.add(attribute);
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public ArrayList<HTMLAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<HTMLAttribute> attributes) {
		this.attributes = attributes;
	}

	public String getInnerHTML() {
		return innerHTML;
	}

	public void setInnerHTML(String innerHTML) {
		this.innerHTML = innerHTML;
	}

	public ArrayList<HTMLTag> getChildTags() {
		return childTags;
	}

	public void setChildTags(ArrayList<HTMLTag> childTags) {
		this.childTags = childTags;
	}

	public void appendToStringBuilder(StringBuilder stringBuilder, int indentLevel) {
		this.stringBuilder = stringBuilder;
		this.indentLevel = indentLevel;
		appendOpeningTag();
		appendInnerHTML();
		appendChildTags();
		appendClosingTag();
	}
	
	private void appendOpeningTag() {
		appendIndent();
		stringBuilder.append("<").append(tagName);
		appendAttributes();
		stringBuilder.append(">\r\n");
	}
	
	private void appendAttributes() {
		for(HTMLAttribute attribute : attributes) {
			attribute.appendToStringBuilder(stringBuilder);
		}
	}
	
	private void appendInnerHTML() {
		if(!innerHTML.equals("")) {
			appendIndent();
			stringBuilder.append("   ").append(innerHTML).append("\r\n");
		}
	}
	
	private void appendClosingTag() {
		appendIndent();
		stringBuilder.append("</").append(tagName).append(">\r\n");
	}
	
	private void appendChildTags() {
		for(HTMLTag tag : childTags) {
			tag.appendToStringBuilder(stringBuilder, indentLevel + 1);
		}
	}
	
	private void appendIndent() {
		for(int x = 0; x<indentLevel; x++) {
			stringBuilder.append("   ");
		}
	}
}
