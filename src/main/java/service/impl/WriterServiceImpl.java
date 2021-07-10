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
    public Writer create(Writer writer) {
        return writerRepository.create(writer);
    }


    @Override
    public Writer update(Writer writer) {
        return writerRepository.update(writer);
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
