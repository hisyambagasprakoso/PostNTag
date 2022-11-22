package com.additional.pnt.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.additional.pnt.model.Posts;
import com.additional.pnt.model.Tags;
import com.additional.pnt.repository.PostRepository;
import com.additional.pnt.repository.TagRepository;
import com.additional.pnt.service.PostService;
import com.additional.pnt.service.TagService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RestController
public class PostController {
    @Autowired
    PostService postService;
    TagRepository tagRepository;
    PostRepository postRepository;
    TagService tagService;

    // creating a get mapping that retrieves all the posts detail from the database
    @GetMapping("/posts")
    private List<Posts> getAllPosts() {
        return postService.getAllPosts();
    }

    // creating a get mapping that retrieves the detail of a specific post
    @GetMapping("/post/{id}")
    private Posts getPost(@PathVariable("id") int id) {
        return postService.getPostsById(id);
    }

    // creating a delete mapping that deletes a specified post
    @DeleteMapping("/post/{id}")
    private void deletePost(@PathVariable("id") int id) {
        postService.delete(id);
    }

    // creating post mapping that post detail in the database
    @PostMapping("/post")
    private int savePost(@RequestBody Posts posts) {
        postService.save(posts);
        return posts.getId();
        // return "Berhasil Tambah Data";
    }

    // creating put mapping that updates the post detail
    @PutMapping("/post/{id}")
    private void update(@PathVariable("id") int id, @RequestBody Posts posts) {
        posts.setId(id);
        postService.update(id, posts);
        // return postRepository
    }

}
