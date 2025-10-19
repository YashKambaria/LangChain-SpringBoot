package com.laingchainexample.spring_boot_langchain.controller;


import com.laingchainexample.spring_boot_langchain.dto.ChatRequest;
import com.laingchainexample.spring_boot_langchain.dto.ChatResponse;
import com.laingchainexample.spring_boot_langchain.model.BookModel;
import com.laingchainexample.spring_boot_langchain.model.MovieModel;
import com.laingchainexample.spring_boot_langchain.service.GenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class GenerativeController {
	
	@Autowired
	public GenAIService genAIService;
	
	@PostMapping
	public ChatResponse getChatResponse(@RequestBody ChatRequest chatRequest){
	  return new ChatResponse(genAIService.getResponse(chatRequest));
	}
	
	@PostMapping("/book")
	public BookModel getBookInfo(@RequestBody ChatRequest chatRequest){
		return genAIService.getModelFromText(chatRequest.question());
	}
	
	@PostMapping("/movie")
	public MovieModel getMovies(@RequestBody ChatRequest chatRequest){
		return genAIService.getMoviesList(chatRequest.question());
	}

}
