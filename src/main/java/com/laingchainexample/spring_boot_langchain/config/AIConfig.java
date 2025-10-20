package com.laingchainexample.spring_boot_langchain.config;

import com.laingchainexample.spring_boot_langchain.service.Assistant;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AIConfig {
	
	@Value("${openAi.key}")
	private String apiKey;
	@Value("${openAi.model}")
	private String modelName;
	@Value("${openAi.baseUrl}")
	private String baseUrl;
	
	
	@Bean
	public Assistant assistant(OpenAiChatModel chatLanguageModel){
		return AiServices.builder(Assistant.class)
				.chatModel(chatLanguageModel)
				.chatMemoryProvider(memoryId-> MessageWindowChatMemory.withMaxMessages(10))
				.build();
	}
	
	@Bean
	public OpenAiChatModel chatLanguageMode(){
		return  OpenAiChatModel.builder()
				.apiKey(apiKey)
				.baseUrl(baseUrl)
				.modelName(modelName)
				.responseFormat("json_object")
				.build();
	}
}
