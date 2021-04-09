package org.example.beans;

import java.io.Serializable;

public class LikeBean implements Serializable {

    private  Long id;
    private Long user_id;
    private Long discuss_id;


    public LikeBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiscuss_id() {
        return discuss_id;
    }

    public void setDiscuss_id(Long discuss_id) {
        this.discuss_id = discuss_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
