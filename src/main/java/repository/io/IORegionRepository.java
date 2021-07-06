package repository.io;

import model.Post;
import model.Region;
import repository.RegionRepository;
import util.IOUtil;


import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class IORegionRepository implements RegionRepository {

    private final static String FILE_NAME = "src/main/resources/db.migration/regions.sql";

    public IORegionRepository() {

    }


    @Override
    public Region getById(Long id) {

        List<Region> regionList = getAll();

        Optional<Region> region = regionList.stream()
                .filter((r) -> r.getId() == id)
                .findFirst();
        return region.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит записи с таким ID: " + id));
    }


    @Override
    public Region save(Region region) {
        updateRegionId(region);

        String recording = region.getId() + " | " + region.getRegionName() + ".";
        IOUtil.write(FILE_NAME, recording);

        return region;
    }


    @Override
    public Region update(Region regionName) {
        List<Region> regionList = getAll();

        Optional<Region> resultRegion = regionList.stream()
                .filter((r) -> r.getId() == regionName.getId())
                .findFirst();

        Region foundRegion = resultRegion.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит обновленного элемента"));

        foundRegion.setRegionName(regionName.getRegionName());

        saveAll(regionList);

        return (Region) regionList;
    }


    @Override
    public void deleteById(Long id) {
        List<Region> regionList = getAll();

        Optional<Region> region = regionList.stream()
                .filter((r) -> r.getId() == id)
                .findFirst();

        regionList.remove(region.orElseThrow(() ->
                new NoSuchElementException("Репозиторий не содержит записи с таким ID: " + id)));
        saveAll(regionList);
    }


    @Override
    public List<Region> getAll() {

        List<String> fileList = IOUtil.read(FILE_NAME);

        int id = 0;
        int regionName = 1;

        return fileList.stream()
                .map((s) -> {

                    String[] parts = s.split(" | ");
                    return new Region(Long.valueOf(parts[id]),
                            parts[regionName]);
                }).collect(Collectors.toList());
    }

    @Override
    public Long getLastId() {
        List<Region> fileList = getAll();


        if (fileList.size() != 0) {
            return fileList.get(fileList.size() - 1).getId();
        }

        return 0L;
    }


    private void updateRegionId(Region regionName) {
        List<Region> regionList = getAll();

        Long id = regionList.size() == 0 ? 1 : regionList.get(regionList.size() - 1).getId() + 1;
        regionName.setId(id);
    }


    private void saveAll(List<Region> list) {

        List<String> regionList = new ArrayList<>();

        for (Region region : list) {
            regionList.add(region.toString());
        }

        IOUtil.writeList(FILE_NAME, regionList);
    }

}
