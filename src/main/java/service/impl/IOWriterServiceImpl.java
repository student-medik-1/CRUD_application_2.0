package service.impl;

import model.Post;
import model.Region;
import model.Writer;
import repository.WriterRepository;
import service.WriterService;

import java.util.List;

public class IOWriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    public IOWriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }


    @Override
    public Writer getById(Long id) {
        return writerRepository.getById(id);
    }


    @Override
    public void create(String firstName, String lastName, List<Post> posts, Region regionName) {

        Writer writer = new Writer();

        writer.setId(writerRepository.getLastId() + 1);
        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        writer.setPosts(posts);
        writer.setRegionName(regionName);

        writerRepository.save(writer);
    }


    @Override
    public void update(Long id, String firstName, String lastName, List<Post> posts, Region regionName) {
        Writer writer = new Writer();

        writer.setId(id);
        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        writer.setPosts(posts);
        writer.setRegionName(regionName);

        writerRepository.save(writer);
    }


    @Override
    public void delete(Long id) {
        Writer writer = getById(id);

        writerRepository.deleteById(writer.getId());
    }


    @Override
    public List<Writer> getAll() {
        return writerRepository.getAll();
    }


}
