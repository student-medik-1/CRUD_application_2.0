package service;

import model.Region;

public interface RegionService extends GenericService<Region, Long>{

    Region create(String regionName, Long writerId);
    Region update (Long id, String regionName, Long writerId);
}
