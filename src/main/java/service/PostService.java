package service;

import model.Post;

import java.time.LocalDateTime;

public interface PostService extends GenericService<Post, Long> {

    Post create(String content, LocalDateTime created);
    Post update(Long id, String content, LocalDateTime updated);
}
