package repository;

import model.Region;

public interface RegionRepository extends GenericRepository <Region, Long> {

    Region create(String regionName, Long writerId);
    Region update (Long id, String regionName, Long writerId);
}
