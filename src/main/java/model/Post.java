package model;

import java.time.LocalDateTime;

public class Post implements Storable{

    private Long id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post(Long id, String posts, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.content = posts;
        this.created = created;
        this.updated = updated;
    }

    public Post(String posts) {
        this.content = posts;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        this.content = ((Post)storable).getContent();
        updated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Posts \n" +
                "ID: " + id +
                " | created: " + created +
                " | updated: " + updated +
                "\n content: " + content;
    }
}
