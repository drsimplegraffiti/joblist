package com.example.joblist.Controller;

import com.example.joblist.PostRepository;
import com.example.joblist.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    //inject the PostRepository
    @Autowired
    PostRepository postRepository;

    // Home page
    @GetMapping("/")
    public String index(HttpServletResponse response) {
       return "hello";
    }

    // Get all posts
    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    // Create a new post
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) { // Post is the object that will be created while post is the name of the object
        return postRepository.save(post);
    }

    // Get a single post
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable String id) {
        return postRepository.findById(id).get();
    }

    // Update a post
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post post) {
        Post existingPost = postRepository.findById(id).get();
        existingPost.setProfile(post.getProfile());
        existingPost.setDescription(post.getDescription());
        existingPost.setExperience(post.getExperience());
        existingPost.setTechs(post.getTechs());
        existingPost.setLocation(post.getLocation());
        return postRepository.save(existingPost);
    }

    // Delete a post
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable String id) {
        postRepository.deleteById(id);
        return "Post deleted";
    }

}
