package model;

import java.time.LocalDateTime;

public class Post {

    private Long id;
    private String content;
    private Long writerId;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }

    public Post(Long id, String content,LocalDateTime created, LocalDateTime updated, Long writerId) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.writerId = writerId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public void setContent(String content) {
        this.content = content;
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
    public String toString() {
        return  "  " + id + " | " + writerId + " | " + created + " | " + updated + " | " + content;
    }
}
