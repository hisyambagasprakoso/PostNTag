package com.additional.pnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.additional.pnt.model.Tags;
import com.additional.pnt.repository.TagRepository;
import com.additional.pnt.service.PostService;
import com.additional.pnt.service.TagService;

@RestController
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    private List<Tags> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/tag/{tagid}")
    private Tags getTag(@PathVariable("tagid") int id) {
        return tagService.getTagsById(id);
    }

    @DeleteMapping("/tag/{tagid}")
    private void deleteTag(@PathVariable("tagid") int id) {
        tagService.delete(id);
    }

    @PostMapping("/tag")
    private int saveTags(@RequestBody Tags tags) {
        tagService.save(tags);
        return tags.getTagid();
        // return "Berhasi
    }

    @PutMapping("/tag/{tagid}")
    private void update(@RequestBody Tags tags, @PathVariable("tagid") int id) {
        tags.setTagid(id);
        tagService.update(tags, id);
        // tagService.saveOrUpdate(tags);
        // return tags;
    }

}
