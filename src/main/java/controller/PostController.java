package controller;

import model.Post;
import service.PostService;
import service.impl.PostServiceImpl;

import java.util.List;

public class PostController {

    private  final PostService postService = new PostServiceImpl();

    public Post getById(Long id) {
        return postService.getById(id);
    }

    public Post create(String content, Long writerId) {
        return postService.create(content, writerId);
    }

    public Post update(Long id, String content, Long writerId) {
        return postService.update(id, content, writerId);
    }

    public void deleteById(Long id) {
        postService.delete(id);
    }

    public List<Post> getAll() {
        return postService.getAll();
    }
}
