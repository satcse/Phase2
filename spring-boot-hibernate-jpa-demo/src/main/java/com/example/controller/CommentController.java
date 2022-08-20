package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Comment;
import com.example.repository.CommentRepository;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired //DI
	CommentRepository commentRepository;
	
	@GetMapping("/comments") // localhost:8080/api/comments --HTTP GET Requests are issued from a REST Client - POSTMAN
	public List<Comment> getAllComments()
	{
		System.out.println("Inside GET API...");
		return commentRepository.findAll();
	}
	
	@PostMapping("/comments") // localhost:8080/api/comments --HTTP POST
	public Comment createComment(@RequestBody Comment comment)
	{
		System.out.println("Inside POST");
		return commentRepository.save(comment); // JPA Repository provides the capabilities to do Create, Read, Update , Delete, Pagination, Sorting etc by default
	}
	
}
