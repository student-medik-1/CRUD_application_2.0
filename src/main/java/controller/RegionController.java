package controller;

import model.Region;
import service.RegionService;
import service.impl.RegionServiceImpl;

import java.util.List;

public class RegionController {

    private final RegionService regionService = new RegionServiceImpl();

    public Region getById(Long id) {
        return regionService.getById(id);
    }

    public Region create(String regionName,Long writerId) {
        return regionService.create(regionName,writerId);
    }

    public Region update(Long id, String regionName,Long writerId) {
        return regionService.update(id,regionName,writerId);
    }

    public void deleteById(Long id) {
        regionService.delete(id);
    }

    public List<Region> getAll() {
        return regionService.getAll();
    }

}
