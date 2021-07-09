package service;

import model.Post;

import java.time.LocalDateTime;

public interface PostService extends GenericService<Post, Long> {

    Post create(String content, Long writer_id);
    Post update(Long id, String content, Long writer_id);
}
