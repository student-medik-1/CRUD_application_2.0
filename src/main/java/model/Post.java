package model;

import java.time.LocalDateTime;

public class Post implements Storable{

    private Long id;
    private String posts;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Post(Long id) {
        this.id = id;
    }

    public Post(Long id, String posts, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.posts = posts;
        this.created = created;
        this.updated = updated;
    }

    public Post(String posts) {
        this.posts = posts;
        created =  LocalDateTime.now();
        updated = LocalDateTime.now();
    }


    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
        updated = LocalDateTime.now();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }



    @Override
    public void copyFrom(Storable storable) {

        this.posts = ((Post)storable).getPosts();
        updated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Posts \n" +
                "ID: " + id +
                " | created: " + created +
                " | updated: " + updated +
                "\n post: " + posts;
    }
}
