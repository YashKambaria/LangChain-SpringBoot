package com.laingchainexample.spring_boot_langchain.service;

import com.laingchainexample.spring_boot_langchain.dto.ChatRequest;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
		List<ChatMessage> messages=new ArrayList<>();
		messages.add(SystemMessage.systemMessage("Respond in Hindi"));
		messages.add(UserMessage.userMessage(request.question()));
		var model = OpenAiChatModel.builder()
				.apiKey(apiKey)
				.baseUrl(baseUrl)
				.modelName(modelName)
				.build();
		return model.chat(messages).aiMessage().text();
	}
}
