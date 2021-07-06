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
    public void create(String posts, LocalDateTime created) {
        Post post = new Post();

        post.setId(postRepository.getLastId() + 1);
        post.setPosts(posts);
        post.setCreated(created);

        postRepository.save(post);
    }

    @Override
    public void update(Long id, String posts, LocalDateTime created, LocalDateTime updated) {
        Post post = new Post();

        post.setId(id);
        post.setPosts(posts);
        post.setCreated(created);
        post.setUpdated(updated);

        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        Post post = getById(id);

        postRepository.deleteById(post.getId());
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }


}
