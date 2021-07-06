package model;

public class Region implements Storable{

    private Long id;
    private String regionName;

    public Region() {
    }

    public Region(Long id) {
        this.id = id;
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Region(Long id, String regionName) {
        this.id = id;
        this.regionName = regionName;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override

    public Long getId() {
        return id;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }



    @Override
    public void copyFrom(Storable storable) {
        this.regionName = ((Region)storable).getRegionName();
    }

    @Override
    public String toString() {
        return "Region: " + "ID: " + id + " Region name: " +  regionName;
    }
}
