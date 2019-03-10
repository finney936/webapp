package com.training.maven.beans;

import java.util.ArrayList;

public class WebhoseResponse {

	private ArrayList<Post> posts;
	private long totalResults;
	private long moreResultsAvailable;
	private String next;
	private long requestsLeft;
	
	public ArrayList<Post> getposts() {
		return posts;
	}
	public void setposts(ArrayList<Post> posts) {
		this.posts = posts;
	}
	public long getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}
	public long getMoreResultsAvailable() {
		return moreResultsAvailable;
	}
	public void setMoreResultsAvailable(long moreResultsAvailable) {
		this.moreResultsAvailable = moreResultsAvailable;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public long getRequestsLeft() {
		return requestsLeft;
	}
	public void setRequestsLeft(long requestsLeft) {
		this.requestsLeft = requestsLeft;
	}
	
	public String toString() {

		for(Post post: posts)
			System.out.println(post);
		
		return "";
	}
	
}