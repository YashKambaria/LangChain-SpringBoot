package com.laingchainexample.spring_boot_langchain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookModel {
	
	private Integer id;
	private String bookName;
	private String description;
	private String genre;
	private LocalDate dateOfPublication;
	private String authorName;
}
