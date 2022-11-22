package com.additional.pnt.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Posts {
    @Id
    // @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(unique = true)
    // @EmbeddedId
    private int id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToMany
    @Column
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "tagid"), inverseJoinColumns = @JoinColumn(name = "postid"))
    Set<Tags> postTag = new HashSet<>();
    // private int tagid;

    public Set<Tags> getPostTag() {
        return postTag;
    }

    public void setPostTag(Set<Tags> postTag) {
        this.postTag = postTag;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void save(Posts posts) {
    }

}
