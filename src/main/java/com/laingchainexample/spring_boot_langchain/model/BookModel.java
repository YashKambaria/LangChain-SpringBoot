package com.laingchainexample.spring_boot_langchain.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookModel {
	
	private Integer id;
	private String bookName;
	@Description("Should be less then 20 words")
	private String description;
	private String genre;
	private LocalDate dateOfPublication;
	private String authorName;
}
