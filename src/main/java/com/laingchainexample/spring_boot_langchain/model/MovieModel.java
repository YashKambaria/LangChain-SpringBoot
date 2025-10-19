package com.laingchainexample.spring_boot_langchain.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieModel {
	
	private Integer id;
	private List<MovieData> listOfMovies;
}

@Data
class MovieData{
	private String name;
	private String genre;
	private String description;
	private LocalDate releaseDate;
	private Float IMDB;
}
