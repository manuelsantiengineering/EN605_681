package com.msanti16.servlet.utils;

public abstract class GenerateHtml implements HtmlGenerator {
	private String html;
	private String head;
	private String body;
	
	public String getHtml() {	
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public void buildHead(String extraParts) {
		StringBuilder strBld = new StringBuilder();
		strBld.append("<head>");	
		strBld.append(
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>    \r\n" + 
				"  <title>Beartooth Hiking Company</title>"
				);		
		if(extraParts.length() > 0) {
			strBld.append(extraParts);
		}		
		strBld.append("</head>");		
		this.head = strBld.toString();
	}
	
	public void buildBody(String extraParts) {
		StringBuilder strBld = new StringBuilder();
		strBld.append("<body bgcolor=\"#B0F5B0\" text=\"#000000\" link=\"#0000EE\" vlink=\"#551A8B\" alink=\"#FF0000\">");
		if(extraParts.length() > 0) {
			strBld.append(extraParts);
		}	
		strBld.append("</body>");		
		this.body = strBld.toString();
	}
	
	
	public void buildHtml() {
		StringBuilder strBld = new StringBuilder();
		strBld.append("<html>");
		strBld.append(this.head);
		strBld.append(this.body);
		strBld.append("</html>");		
		this.html = strBld.toString();
	}
	
	
	public void buildHtml(String extraHead, String extraBody) {
		this.buildHead(extraHead);
		this.buildBody(extraBody);
		StringBuilder strBld = new StringBuilder();
		strBld.append("<html>");
		strBld.append(this.head);
		strBld.append(this.body);
		strBld.append("</html>");		
		this.html = strBld.toString();
	}
	
	@Override
	public String toString() {
		return this.getHtml();
	}
}
