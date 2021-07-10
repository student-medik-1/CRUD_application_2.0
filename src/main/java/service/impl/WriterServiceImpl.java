package service.impl;

import model.Writer;
import repository.WriterRepository;
import repository.jdbc.JdbcWriterRepositoryImpl;
import service.WriterService;

import java.util.List;

public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository = new JdbcWriterRepositoryImpl();


    @Override
    public Writer getById(Long id) {
        return writerRepository.getById(id);
    }


    @Override
    public Writer create(String firstName, String lastName) {
        return writerRepository.create(firstName, lastName);
    }


    @Override
    public Writer update(Long id, String firstName, String lastName) {
        return writerRepository.update(id, firstName, lastName);
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
