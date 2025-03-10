package com.wipro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BlogDTO {
	
	private Long id;

	
	    @NotBlank(message = "Blog title must not be null or empty")
	    @Size(min = 3, max = 100, message = "Blog title must be between 3 and 100 characters")
	    private String title;
	    
	    @NotBlank(message = "Blog content must not be null or empty")
	    @Size(min = 3, max = 200, message = "Blog content must be between 3 and 200 characters")
	    private String content;
	
	
	   
	

       private String author;

    // Constructors
    public BlogDTO() {}

    public BlogDTO(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
