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

    public Post create(Post post) {
        return postService.create(post);
    }

    public Post update(Post post) {
        return postService.update(post);
    }

    public void deleteById(Long id) {
        postService.delete(id);
    }

    public List<Post> getAll() {
        return postService.getAll();
    }
}
