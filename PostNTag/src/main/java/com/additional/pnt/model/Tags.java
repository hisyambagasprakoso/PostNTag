package com.additional.pnt.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Tags {
    @Id
    @Column(unique = true)
    // @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagid;

    @Column
    private String label;

    @JsonIgnore
    @ManyToMany(mappedBy = "postTag")
    Set<Posts> pt = new HashSet<>();;

    public Set<Posts> getPt() {
        return pt;
    }

    public void setPt(Set<Posts> pt) {
        this.pt = pt;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
