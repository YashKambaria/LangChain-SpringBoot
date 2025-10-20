package com.laingchainexample.spring_boot_langchain.service;

import com.laingchainexample.spring_boot_langchain.dto.ChatRequest;
import com.laingchainexample.spring_boot_langchain.model.BookModel;
import com.laingchainexample.spring_boot_langchain.model.MovieModel;

import java.util.List;

public interface GenAIService {
	String getResponse(ChatRequest request);
	
	BookModel getModelFromText(String question);
	
	MovieModel getMoviesList(String question);
}
