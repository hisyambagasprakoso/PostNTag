package com.additional.pnt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.additional.pnt.model.Tags;
import com.additional.pnt.repository.TagRepository;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public List<Tags> getAllTags() {
        List<Tags> tags = new ArrayList<Tags>();
        tagRepository.findAll().forEach(tags1 -> tags.add(tags1));
        return tags;
    }

    // getting a specific record by using the method findById() of CrudRepository
    public Tags getTagsById(int id) {
        return tagRepository.findById(id).get();
    }

    // saving a specific record by using the method save() of CrudRepository
    public void save(Tags tags) {
        tagRepository.save(tags);
    }

    // deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        tagRepository.deleteById(id);
    }

    // updating a record
    public void update(Tags tags, int id) {
        tagRepository.save(tags);
    }

}
