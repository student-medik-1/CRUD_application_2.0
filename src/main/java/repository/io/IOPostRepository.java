package repository.io;

import model.Post;
import model.Region;
import repository.PostRepository;
import util.IOUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class IOPostRepository implements PostRepository {

    private final static String FILE_NAME = "src/main/resources/db.migration/posts.sql";

    public IOPostRepository() {
    }


    @Override
    public Post getById(Long id) {
        List<Post> postsList = getAll();

        Optional<Post> post = postsList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        return post.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит записи с таким ID: " + id));
    }


    @Override
    public Post save(Post post) {
        updatePostId(post);

        String recording = post.getId() + " | " + post.getPosts() + " | "
                + post.getCreated() + " | " + post.getUpdated();
        IOUtil.write(FILE_NAME, recording);

        return post;
    }


    @Override
    public Post update(Post post) {
        List<Post> postsList = getAll();

        Optional<Post> resultPostOptional = postsList.stream()
                .filter(p -> p.getId() == post.getId())
                .findFirst();
        Post resultPost = resultPostOptional.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит обновленного элемента"));
        resultPost.setPosts(post.getPosts());

        saveAll(postsList);

        return resultPost;
    }


    @Override
    public void deleteById(Long id) {
        List<Post> postsList = getAll();

        Optional<Post> post = postsList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        postsList.remove(post.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит записи с таким ID: " + id)));
        saveAll(postsList);
    }


    @Override
    public List<Post> getAll() {
        List<String> fileList = IOUtil.read(FILE_NAME);

        int id = 0;
        int content = 1;
        int created = 2;
        int updated = 3;

        return fileList.stream()
                .map(s -> {

                    String[] parts = s.split(" | ");
                    return new Post(Long.valueOf(parts[id]),
                            parts[content],
                            LocalDateTime.parse(parts[created]),
                            LocalDateTime.parse(parts[updated]));

                }).collect(Collectors.toList());
    }

    @Override
    public Long getLastId() {
        List<Post> fileList = getAll();

        if (fileList.size() != 0) {
            return fileList.get(fileList.size() - 1).getId();
        }

        return 0L;
    }


    private void saveAll(List<Post> list) {
        List<String> regionList = new ArrayList<>();

        for (Post post : list) {
            regionList.add(post.toString());
        }

        IOUtil.writeList(FILE_NAME, regionList);
    }


    private void updatePostId(Post post) {
        List<Post> postsList = getAll();

        Long id = postsList.size() == 0 ? 1 : postsList.get(postsList.size() - 1).getId() + 1;
        post.setId(id);
    }

}
