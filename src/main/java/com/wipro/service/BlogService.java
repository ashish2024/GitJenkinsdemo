package com.wipro.service;

import java.util.List;

import com.wipro.dto.BlogDTO;

public interface BlogService {
	
	
	BlogDTO createBlog(BlogDTO blogDTO);
    BlogDTO getBlogById(Long id);
    BlogDTO updateBlog(Long id, BlogDTO blogDTO);
    Boolean deleteBlog(Long id);
    List<BlogDTO> findAll();

}
