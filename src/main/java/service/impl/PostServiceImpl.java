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
    public Post create(String content, Long writer_id) {

        postRepository.create(new Post(content, writer_id));
        return new Post(content, writer_id);
    }

    @Override
    public Post update(Long id, String content,  Long writer_id) {

        postRepository.create(new Post(id, content,  writer_id));
        return new Post(id, content,  writer_id);
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
