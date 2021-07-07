package service.impl;

import model.Region;
import repository.RegionRepository;
import repository.jdbc.JdbcRegionRepositoryImpl;
import service.RegionService;

import java.util.List;

public class IORegionServiceImpl implements RegionService {

    private  RegionRepository regionRepository = new JdbcRegionRepositoryImpl();


    public IORegionServiceImpl(RegionRepository regionRepository) {

        this.regionRepository = regionRepository;
    }


    @Override
    public Region getById(Long id) {
        return regionRepository.getById(id);
    }


    @Override
    public Region create(String regionName) {
        Region region = new Region();

        region.setRegionName(regionName);

        regionRepository.create(region);

        return region;
    }


    @Override
    public Region update(Long id, String regionName) {
        Region region = new Region();

        region.setId(id);
        region.setRegionName(regionName);

        regionRepository.update(region);

        return region;
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
