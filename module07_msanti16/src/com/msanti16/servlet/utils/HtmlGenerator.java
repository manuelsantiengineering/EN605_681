package com.msanti16.servlet.utils;

public interface HtmlGenerator {
	
	public String getHtml();
	
	public void setHtml(String html);
	
	public String getHead();
	
	public void setHead(String head);
	
	public String getBody();
	
	public void setBody(String body);
	
	public void buildHtml();
	
	public void buildHead(String extraParts);
	
	public void buildBody(String extraParts);
}
