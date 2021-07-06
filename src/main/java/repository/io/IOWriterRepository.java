package repository.io;

import model.Post;
import model.Region;
import model.Writer;
import repository.PostRepository;
import repository.RegionRepository;
import repository.WriterRepository;
import util.IOUtil;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class IOWriterRepository implements WriterRepository {

    private final String FILE_NAME = "src/main/resources/db.migration/writers.sql";


    private final PostRepository postRepository;
    private final RegionRepository regionRepository;


    public IOWriterRepository() {
        this.postRepository = new IOPostRepository();
        this.regionRepository = new IORegionRepository();
    }


    @Override
    public Writer getById(Long id) {
        List<Writer> writerList = getAll();

        Optional<Writer> writer = writerList.stream()
                .filter(w -> w.getId() == id)
                .findFirst();

        return writer.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит записи с таким ID: " + id));
    }


    @Override
    public Writer save(Writer writer) {
        updateWriterId(writer);

        String recorded = writerToStringRecorded(writer);
        IOUtil.write(FILE_NAME, recorded);

        return writer;
    }


    @Override
    public Writer update(Writer writer) {
        List<Writer> writerList = getAll();

        Optional<Writer> resultUserOptional = writerList.stream()
                .filter(w -> w.getId() == writer.getId())
                .findFirst();

        Writer resultWriter = resultUserOptional.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит обновленного элемента"));

        resultWriter.setFirstName(writer.getFirstName());
        resultWriter.setLastName(writer.getLastName());
        resultWriter.setRegionName(writer.getRegionName());
        resultWriter.setPosts(writer.getPosts());

        saveAll(writerList);

        return (Writer) writerList;
    }


    @Override
    public void deleteById(Long id) {
        List<Writer> writerList = getAll();

        Optional<Writer> writer = writerList.stream()
                .filter(w -> w.getId() == id)
                .findFirst();

        writerList.remove(writer.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит записи с таким ID: " + id)));

        saveAll(writerList);
    }


    @Override
    public List<Writer> getAll() {
        List<String> fileString = IOUtil.read(FILE_NAME);


        return fileString.stream()
                .map(s -> {

                    String[] writerParts = s.split(" | ");
                    return new Writer(Long.valueOf(writerParts[0]),
                            writerParts[1],
                            writerParts[2],
                            postListFromString(writerParts[3]),
                            getRegion(Long.valueOf(writerParts[4])));

                }).collect(Collectors.toList());
    }

    @Override
    public Long getLastId() {
        List<Writer> fileList = getAll();

        if (fileList.size() != 0) {
            return fileList.get(fileList.size() - 1).getId();
        }

        return 0L;
    }

    private void updateWriterId(Writer writer) {

        List<Writer> writerList = getAll();

        Long id = writerList.size() == 0 ? 1 : writerList.get(writerList.size() - 1).getId() + 1;
        writer.setId(id);

    }

    private String writerToStringRecorded(Writer writer) {

        return writer.getId() + " | " + writer.getFirstName() + " | " + writer.getLastName()
                + " | " + writer.getRegionName() + " | " + postListToString(writer.getPosts()) + ".";
    }


    private String postListToString(List<Post> postList) {

        if (postList == null || postList.size() == 0) {
            return " ";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Post post : postList) {

            stringBuilder.append(post.getId()).append(" | ");
        }

        return stringBuilder.toString();
    }


    private List<Post> postListFromString(String encodePostList) {

        String[] postsId = encodePostList.split(" | ");

        if (postsId.length == 1 && postsId[0].equals("0")) {
            return new ArrayList<>();
        }

        List<Post> postList = new ArrayList<>();

        for (String postId : postsId) {
            postList.add(postRepository.getById(Long.valueOf(postId)));
        }
        return postList;
    }


    private void saveAll(List<Writer> list) {

        List<String> writerList = new ArrayList<>();

        for (Writer writer : list) {
            writerList.add(writer.toString());
        }

        IOUtil.writeList(FILE_NAME, writerList);
    }


    private Region getRegion(Long id) {
        return regionRepository.getById(id);
    }
}
