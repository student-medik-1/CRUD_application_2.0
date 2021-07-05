package service;

import model.Region;

public interface RegionService extends GenericService<Region, Long>{

    void create(String regionName);
    void update(Long id, String regionName);
}
