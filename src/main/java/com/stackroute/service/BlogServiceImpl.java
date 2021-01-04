package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{

    BlogRepository repository;

    @Autowired
    public BlogServiceImpl(BlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        Blog blog = null;
        blog = repository.findById(id).get();
        return blog;
    }

    @Override
    public Blog deleteBlog(int id) {
        Blog blog = null;
        final Optional<Blog> blogTobeDeleted = repository.findById(id);
        if(blogTobeDeleted.isPresent()){
            blog = repository.findById(id).get();
            repository.deleteById(id);
            return blog;
        }
        return null;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        final Optional<Blog> blogToBeUpdated = repository.findById(blog.getBlogId());
        if(blogToBeUpdated.isPresent()){
            final Blog updatedBlog = repository.save(blog);
            return repository.findById(blog.getBlogId()).get();
        }
        return null;
    }
}
