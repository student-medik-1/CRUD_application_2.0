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

    public Region create(Region region) {
        return regionService.create(region);
    }

    public Region update(Region region) {
        return regionService.update(region);
    }

    public void deleteById(Long id) {
        regionService.delete(id);
    }

    public List<Region> getAll() {
        return regionService.getAll();
    }

}
