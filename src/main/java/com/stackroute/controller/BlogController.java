package com.stackroute.controller;


import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* Add annotation to declare this class as REST Controller */

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity(blogService.saveBlog(blog), HttpStatus.CREATED);
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("/blog/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") int blogId){
        return new ResponseEntity<>(blogService.getBlogById(blogId), HttpStatus.FOUND);
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("/blog/{blogId}")
    public ResponseEntity<?> getBlogAfterDeleting(@PathVariable("blogId") int blogId) {
        return new ResponseEntity<>(blogService.deleteBlog(blogId), HttpStatus.OK);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping("/blog")
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.updateBlog(blog), HttpStatus.OK);
    }
}