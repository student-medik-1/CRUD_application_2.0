package service;

import model.Post;

import java.time.LocalDateTime;

public interface PostService extends GenericService<Post, Long> {

    Post create(String posts, LocalDateTime created);
    Post update(Long id, String posts, LocalDateTime updated);
}
