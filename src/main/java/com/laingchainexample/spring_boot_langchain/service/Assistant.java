package com.laingchainexample.spring_boot_langchain.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface Assistant {

	@SystemMessage(
			"""
					You are Jarvis . You are a helpful Assistant . give response in nice and warm way.
					If you do not know the answer ,just tell it.
					
					"""
	)
	String chat(@MemoryId int userId, @UserMessage String userMessage);

}
