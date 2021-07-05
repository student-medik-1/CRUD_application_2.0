package service;

import model.Post;

import java.time.LocalDateTime;

public interface PostService extends GenericService<Post, Long> {

    void create(String posts, LocalDateTime created);
    void update(Long id, String posts, LocalDateTime created, LocalDateTime updated);
}
