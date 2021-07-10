package service.impl;

import model.Region;
import repository.RegionRepository;
import repository.jdbc.JdbcRegionRepositoryImpl;
import service.RegionService;

import java.util.List;

public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository = new JdbcRegionRepositoryImpl();

    @Override
    public Region getById(Long id) {
        return regionRepository.getById(id);
    }


    @Override
    public Region create(Region region) {
        return regionRepository.create(region);
    }


    @Override
    public Region update(Region region) {
        return regionRepository.update(region);
    }


    @Override
    public void delete(Long id) {
        regionRepository.deleteById(id);
    }


    @Override
    public List<Region> getAll() {
        return regionRepository.getAll();
    }


}
