package com.additional.pnt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.additional.pnt.model.Tags;

@Repository
public interface TagRepository extends CrudRepository<Tags, Integer> {

}
