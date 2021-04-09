package org.example.beans;

import java.io.Serializable;

public class CommentBean implements Serializable {

    private Long id;
    private String content;
    private Long user_id;
    private Long discussion_id;


    public CommentBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(Long discussion_id) {
        this.discussion_id = discussion_id;
    }
}
