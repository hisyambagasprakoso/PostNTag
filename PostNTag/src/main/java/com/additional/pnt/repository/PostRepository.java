package com.additional.pnt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.additional.pnt.model.Posts;

@Repository
public interface PostRepository extends CrudRepository<Posts, Integer> {

}
