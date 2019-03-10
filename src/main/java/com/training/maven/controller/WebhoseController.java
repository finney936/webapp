package com.training.maven.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.maven.beans.Post;
import com.training.maven.beans.WebhoseResponse;

@RestController
public class WebhoseController {

    @RequestMapping("/api")
    public WebhoseResponse greeting() {
    	
    	WebhoseResponse webhoseResponse
    	= new WebhoseResponse();
    	
    	Post post1 = new Post();
    	post1.setUrl("google.com");
    	post1.setTitle("GOOGLE");
    	post1.setText("World's best search engine");
    	
    	Post post2 = new Post();
    	post2.setUrl("bing.com");
    	post2.setTitle("BING");
    	post2.setText("World's second best search engine");
    	
    	ArrayList<Post> posts = new ArrayList<>();
    	
    	posts.add(post1);
    	posts.add(post2);
    	
    	webhoseResponse.setposts(posts);
    	webhoseResponse.setTotalResults(2);
    	webhoseResponse.setRequestsLeft(999);
    	webhoseResponse.setMoreResultsAvailable(0);
    	webhoseResponse.setNext("yahoo.com");
    	
        return webhoseResponse;
    }
}
