package com.laingchainexample.spring_boot_langchain.service;

import com.laingchainexample.spring_boot_langchain.dto.ChatRequest;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GenAIServiceImpl implements GenAIService{
	
	@Value("${openAi.key}")
	private String apiKey;
	@Value("${openAi.model}")
	private String modelName;
	@Value("${openAi.baseUrl}")
	private String baseUrl;
	
	@Override
	public String getResponse(ChatRequest request) {
		var model = OpenAiChatModel.builder()
				.apiKey(apiKey)
				.baseUrl(baseUrl)
				.modelName(modelName)
				.build();
		return model.chat(request.question());
	}
}
