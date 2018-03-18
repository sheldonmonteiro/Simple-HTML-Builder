package com.htmlbuilder;

import java.util.ArrayList;

public class HTMLBuilder {

	private ArrayList<HTMLTag> tags = new ArrayList<HTMLTag>();
	
	public HTMLBuilder() {
	}
	
	public void add(HTMLTag tag) {
		tags.add(tag);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		int indentLevel = 0;
		for(HTMLTag tag : tags) {
			tag.appendToStringBuilder(stringBuilder, indentLevel);
		}
		
		return stringBuilder.toString();
	}

}
