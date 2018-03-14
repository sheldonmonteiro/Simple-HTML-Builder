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
		for(HTMLTag tag : tags) {
			stringBuilder.append(tag.toString());
		}
		
		return stringBuilder.toString();
	}

}
