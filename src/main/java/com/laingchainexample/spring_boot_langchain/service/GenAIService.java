package com.laingchainexample.spring_boot_langchain.service;

import com.laingchainexample.spring_boot_langchain.dto.ChatRequest;
import com.laingchainexample.spring_boot_langchain.model.BookModel;

public interface GenAIService {
	String getResponse(ChatRequest request);
	
	BookModel getModelFromText(String question);
}
