package com.laingchainexample.spring_boot_langchain.service;

import com.laingchainexample.spring_boot_langchain.dto.ChatRequest;

public interface GenAIService {
	String getResponse(ChatRequest request);

}
