package com.additional.pnt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.additional.pnt.model.Posts;
import com.additional.pnt.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Posts> getAllPosts() {
        List<Posts> posts = new ArrayList<Posts>();
        postRepository.findAll().forEach(posts1 -> posts.add(posts1));
        return posts;
    }

    // getting a specific record by using the method findById() of CrudRepository
    public Posts getPostsById(int id) {
        return postRepository.findById(id).get();
    }

    // saving a specific record by using the method save() of CrudRepository
    public void save(Posts posts) {
        postRepository.save(posts);
    }

    // deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        postRepository.deleteById(id);
    }

    // updating a record
    public void update(int id, Posts posts) {
        postRepository.save(posts);
    }

}
