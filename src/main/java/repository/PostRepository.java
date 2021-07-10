package repository;

import model.Post;

public interface PostRepository extends GenericRepository <Post, Long> {

    Post create(Long writerId, String content);
    Post update (Long id, Long writerId, String content);
}
