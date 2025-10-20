package com.laingchainexample.spring_boot_langchain.service;

import com.laingchainexample.spring_boot_langchain.model.BookModel;
import com.laingchainexample.spring_boot_langchain.model.MovieModel;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

import java.util.List;

public interface Assistant {

	@SystemMessage(
			"""
					You are Jarvis . You are a helpful Assistant . give response in nice and warm way.
					If you do not know the answer ,just tell it.
					
					"""
	)
	String chat(@MemoryId int userId, @UserMessage String userMessage);
	
	@SystemMessage("""
			You are an assistant that extracts book information.
			All output must be in English. If the input text contains any non-English text, translate it to English first, then extract the information.
			""")
	@UserMessage("""
			Extract book information from the text. If the book title, author, or genre is not explicitly mentioned,\s
			              make your best guess based on the content. All output must be in English.\s
			              if you do not find the book give your best guess and strictly give response back in json_object.\s
			              Return JSON with keys: bookName, authorName, description, genre, dateOfPublication.
			              Text: {{text}}
			              also the genre in the specified type genre : {{genre}}
			""")
	BookModel extractBookInfo(@V("text") String text,@V("genre") List<String> genre);
	
	@SystemMessage("""
			You are an Movie Recommender.You know the best movies ever for every theme
			""")
	@UserMessage("""
			Extract the information about the movies .Find the best movies that you can find. store them in the list of  name,genre,description,releaseDate
			Text : {{text}}
			""")
	MovieModel findMoviesFromTheme(@V("text") String text);

}
