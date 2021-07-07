package service.impl;

import model.Post;
import repository.PostRepository;
import service.PostService;

import java.time.LocalDateTime;
import java.util.List;

public class IOPostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public IOPostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getById(Long id) {
        return postRepository.getById(id);
    }

    @Override
    public Post create(String content, LocalDateTime created) {
        Post post = new Post();

        post.setContent(content);
        post.setCreated(created);

        postRepository.create(post);
        return post;
    }

    @Override
    public Post update(Long id, String content, LocalDateTime updated) {
        Post post = new Post();

        post.setId(id);
        post.setContent(content);
        post.setUpdated(updated);

        postRepository.create(post);
        return post;
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }


}
