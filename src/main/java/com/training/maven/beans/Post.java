package com.training.maven.beans;

public class Post {
	
	private String url;
	private String title;
	private String text;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		
		return "URL: " + url + "\nTITLE: " + title + 
				"\nTEXT: " + text;
	}
	
}