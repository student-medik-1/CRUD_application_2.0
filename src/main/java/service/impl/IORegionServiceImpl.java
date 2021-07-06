package service.impl;

import model.Region;
import repository.RegionRepository;
import service.RegionService;

import java.util.List;

public class IORegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;


    public IORegionServiceImpl(RegionRepository regionRepository) {

        this.regionRepository = regionRepository;
    }


    @Override
    public Region getById(Long id) {
        return regionRepository.getById(id);
    }

    @Override
    public void create(String regionName) {
        Region region = new Region();

        region.setRegionName(regionName);

        regionRepository.create(region);
    }


    @Override
    public void update(Long id, String regionName) {
        Region region = new Region();

        region.setId(id);
        region.setRegionName(regionName);

        regionRepository.update(region);

    }

    @Override
    public void delete(Long id) {
        Region region = getById(id);

        regionRepository.deleteById(region.getId());
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.getAll();
    }


}
