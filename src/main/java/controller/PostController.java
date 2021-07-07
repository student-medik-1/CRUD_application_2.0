package controller;

import model.Post;
import model.Region;
import service.PostService;

import java.time.LocalDateTime;
import java.util.List;

public class PostController {

    private PostService postService;

    public Post getById(Long id) {
        return postService.getById(id);
    }

    public Post create(String content, LocalDateTime created) {
        return postService.create(content, created);
    }

    public Post update(Long id, String content, LocalDateTime updated) {
        return postService.update(id, content, updated);
    }

    public void deleteById(Long id) {
        postService.delete(id);
    }

    public List<Post> getAll() {
        return postService.getAll();
    }
}
