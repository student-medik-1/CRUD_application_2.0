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
    public Post create(Long writerId, String content) {

        return postRepository.create(writerId, content);
    }

    @Override
    public Post update(Long id, Long writerId, String content) {

        return postRepository.update(id, writerId, content);
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
