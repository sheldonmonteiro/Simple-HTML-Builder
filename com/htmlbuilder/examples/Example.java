package com.htmlbuilder.examples;

import com.htmlbuilder.HTMLAttribute;
import com.htmlbuilder.HTMLBuilder;
import com.htmlbuilder.HTMLTag;

public class Example {
	public static void main(String args[]) {
		HTMLBuilder htmlBuilder = new HTMLBuilder();
		
		HTMLTag body = new HTMLTag("body");
		htmlBuilder.add(body);
		
		HTMLTag testDiv = new HTMLTag("div");
		testDiv.addAttribute(new HTMLAttribute("id","helloWorld"));
		testDiv.setInnerHTML("Hello World!");
		body.addChildTag(testDiv);
		
		HTMLTag hiddenDiv = new HTMLTag("div");
		hiddenDiv.addAttribute(new HTMLAttribute("id","hiddenDiv"));
		hiddenDiv.addAttribute(new HTMLAttribute("hidden"));
		hiddenDiv.setInnerHTML("You can't see me");
		body.addChildTag(hiddenDiv);
		
		System.out.println(htmlBuilder.toString());
	}
}
