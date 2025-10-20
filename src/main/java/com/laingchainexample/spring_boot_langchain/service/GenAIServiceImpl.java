package com.laingchainexample.spring_boot_langchain.service;

import com.laingchainexample.spring_boot_langchain.dto.ChatRequest;
import com.laingchainexample.spring_boot_langchain.model.BookModel;
import com.laingchainexample.spring_boot_langchain.model.MovieModel;
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
	
	private final Assistant assistant;
	@Override
	public String getResponse(ChatRequest request) {
		return assistant.chat(request.userId(),request.question());
	}
	
	@Override
	public BookModel getModelFromText(String question) {
		var genre = List.of("Science Fiction", "Mystery", "Fantasy", "Romance", "Thriller", "Historical Fiction", "Horror", "Biography", "Self‑Help");
		return assistant.extractBookInfo(question,genre);
	}
	
	@Override
	public MovieModel getMoviesList(String question) {
		return assistant.findMoviesFromTheme(question);
	}
	
	public String getResponseSimple(ChatRequest request) {
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
