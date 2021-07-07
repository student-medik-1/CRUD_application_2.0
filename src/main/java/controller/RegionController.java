package controller;

import model.Region;
import service.RegionService;

import java.util.List;

public class RegionController {
    private RegionService regionService;

    public Region getById(Long id) {
        return regionService.getById(id);
    }

    public Region create(String regionName) {
        return regionService.create(regionName);
    }

    public Region update(Long id, String regionName) {
        return regionService.update(id,regionName);
    }

    public void deleteById(Long id) {
        regionService.delete(id);
    }

    public List<Region> getAll() {
        return regionService.getAll();
    }

}
