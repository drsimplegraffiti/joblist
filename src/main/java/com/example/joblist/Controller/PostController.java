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
    public Post createPost(@RequestBody Post post, HttpServletResponse response) { // Post is the object that will be created while post is the name of the object
        try {
            if (post.getProfile() == null || post.getProfile().isEmpty() ||
                    post.getDescription() == null ||
                    post.getDescription().isEmpty() ||
                    post.getExperience() == 0 ||
                    post.getTechs() == null ||
                    post.getTechs().length == 0 ||
                    post.getLocation() == null ||
                    post.getLocation().isEmpty()) {
                response.sendError(400, "All fields are required.");
                return null;
            }

            postRepository.save(post);
            response.setStatus(201);
            return post;
        } catch (Exception e) {
            response.setStatus(500);
            return null;
        }
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable String id, HttpServletResponse response) {
        try {
            if (postRepository.findById(id).isPresent()) {
                return postRepository.findById(id).get();
            } else {
                response.sendError(404, "Post not found");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Update a post
    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post post, HttpServletResponse response) {
        try {
            //validate input coming from request body and return 400 if invalid
            if (post.getProfile() == null ||
                    post.getProfile().equals("") ||
                    post.getDescription() == null ||
                    post.getDescription().equals("") ||
                    post.getExperience() == 0 ||
                    post.getTechs() == null ||
                    post.getTechs().length == 0 ||
                    post.getLocation() == null ||
                    post.getLocation().equals("")) {
                response.sendError(400, "Please provide all required fields");
                return null;
            }


            if (postRepository.findById(id).isPresent()) {
                Post existingPost = postRepository.findById(id).get();
                existingPost.setProfile(post.getProfile());
                existingPost.setDescription(post.getDescription());
                existingPost.setExperience(post.getExperience());
                existingPost.setTechs(post.getTechs());
                existingPost.setLocation(post.getLocation());
                return postRepository.save(existingPost);
            } else {
                response.sendError(404, "Post not found");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    // Delete a post
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable String id, HttpServletResponse response) {
        try {
            if (postRepository.findById(id).isPresent()) {
                postRepository.deleteById(id);
                return "Post deleted";
            } else {
                response.sendError(404, "Post not found");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }


}
