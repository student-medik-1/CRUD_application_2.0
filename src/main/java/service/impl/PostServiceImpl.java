package service.impl;

import model.Post;
import repository.PostRepository;
import repository.jdbc.JdbcPostRepositoryImpl;
import service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository = new JdbcPostRepositoryImpl();

    @Override
    public Post getById(Long id) {
        return postRepository.getById(id);
    }

    @Override
    public Post create(Post post) {
        return postRepository.create(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.update(post);
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
