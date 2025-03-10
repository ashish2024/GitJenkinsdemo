package com.wipro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.BlogDTO;
import com.wipro.entity.BlogEntity;
import com.wipro.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO) {
        BlogEntity blogEntity = new BlogEntity(null, blogDTO.getTitle(), blogDTO.getContent(), blogDTO.getAuthor());
        BlogEntity savedBlog = blogRepository.save(blogEntity);
        return new BlogDTO(savedBlog.getId(), savedBlog.getTitle(), savedBlog.getContent(), savedBlog.getAuthor());
    }

    @Override
    public BlogDTO getBlogById(Long id) {
        BlogEntity blogEntity = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
        return new BlogDTO(blogEntity.getId(), blogEntity.getTitle(), blogEntity.getContent(), blogEntity.getAuthor());
    }

    @Override
    public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
        BlogEntity existingBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
        existingBlog.setTitle(blogDTO.getTitle());
        existingBlog.setContent(blogDTO.getContent());
        existingBlog.setAuthor(blogDTO.getAuthor());

        BlogEntity updatedBlog = blogRepository.save(existingBlog);
        return new BlogDTO(updatedBlog.getId(), updatedBlog.getTitle(), updatedBlog.getContent(), updatedBlog.getAuthor());
    }

    @Override
    public Boolean deleteBlog(Long id) {
        blogRepository.deleteById(id);
        return true;
    }

    @Override
    public List<BlogDTO> findAll() {
        return blogRepository.findAll().stream()
                .map(blog -> new BlogDTO(blog.getId(), blog.getTitle(), blog.getContent(), blog.getAuthor()))
                .collect(Collectors.toList());
    }
}
