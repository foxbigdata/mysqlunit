/*
 * This file is generated by jOOQ.
 */
package com.mysqljooq.assetmanageunit.jooq.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Posts implements Serializable {

    private static final long serialVersionUID = -366417134;

    private Integer   id;
    private String    title;
    private String    content;
    private Timestamp createdOn;


    private List<Comments> comments = new ArrayList<>();

    public Posts() {}

    public Posts(Posts value) {
        this.id = value.id;
        this.title = value.title;
        this.content = value.content;
        this.createdOn = value.createdOn;
    }

    public Posts(
        Integer   id,
        String    title,
        String    content,
        Timestamp createdOn
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Posts (");

        sb.append(id);
        sb.append(", ").append(title);
        sb.append(", ").append(content);
        sb.append(", ").append(createdOn);

        sb.append(")");
        return sb.toString();
    }


    public List<Comments> getComments()
    {
        return comments;
    }
    public void setComments(List<Comments> comments)
    {
        this.comments = comments;
    }
    public void addComment(Comments comment)
    {
        comment.setPost(this);
        this.comments.add(comment);
    }
}
