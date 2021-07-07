package service.impl;

import model.Region;
import model.Writer;
import repository.WriterRepository;
import service.WriterService;

import java.util.List;

public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    public WriterServiceImpl(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }


    @Override
    public Writer getById(Long id) {
        return writerRepository.getById(id);
    }


    @Override
    public Writer create(String firstName, String lastName, Region regionName) {

        Writer writer = new Writer();

        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        writer.setRegionName(regionName);

        writerRepository.create(writer);
        return writer;
    }


    @Override
    public Writer update(Long id, String firstName, String lastName, Region regionName) {
        Writer writer = new Writer();

        writer.setId(id);
        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        writer.setRegionName(regionName);

        writerRepository.update(writer);
        return writer;
    }


    @Override
    public void delete(Long id) {
        writerRepository.deleteById(id);
    }


    @Override
    public List<Writer> getAll() {
        return writerRepository.getAll();
    }


}
