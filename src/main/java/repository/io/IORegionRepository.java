package repository.io;

import model.Region;
import repository.RegionRepository;

import java.util.List;

public class IORegionRepository implements RegionRepository {

    private final static String FILE_NAME = "src/main/resources/db.migration/writers.sql";


    @Override
    public Region getById(Long id) {
        return null;
    }

    @Override
    public Region save(Region region) {
        return null;
    }

    @Override
    public Region update(Region region) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Region> getAll() {
        return null;
    }
}
