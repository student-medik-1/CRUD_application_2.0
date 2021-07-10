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
    public Region create(String regionName, Long writerId) {
        return regionRepository.create(regionName, writerId);
    }


    @Override
    public Region update(Long id, String regionName, Long writerId) {
        return regionRepository.update(id,regionName,writerId);
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
