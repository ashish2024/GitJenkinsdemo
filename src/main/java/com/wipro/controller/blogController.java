package com.wipro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.BlogDTO;
import com.wipro.service.BlogService;

import jakarta.validation.Valid;

@RestController

@RequestMapping("/api/blogs")
public class blogController {
	
	
	
	

	

	    @Autowired
	    private BlogService blogService;

	    @PostMapping
	    public ResponseEntity<?> createBlog(@Valid @RequestBody BlogDTO blogDTO, BindingResult result) {
	        if (result.hasErrors()) {
	            List<String> errors = result.getFieldErrors()
	                    .stream()
	                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
	                    .collect(Collectors.toList());
	            return ResponseEntity.badRequest().body(errors);
	        }
	        return new ResponseEntity<>(blogService.createBlog(blogDTO), HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Long id) {
	        return ResponseEntity.ok(blogService.getBlogById(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogDTO blogDTO) {
	        return ResponseEntity.ok(blogService.updateBlog(id, blogDTO));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Boolean> deleteBlog(@PathVariable Long id) {
	        return ResponseEntity.ok(blogService.deleteBlog(id));
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
	        return ResponseEntity.ok(blogService.findAll());
	    }
	
	
	
	
	
	
	
	
	
	
	
	

}
