package model;

public class Region {

    private Long id;
    private String regionName;
    private Long writerId;


    public Region() {
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }


    public Region(Long id, String regionName, Long writerId) {
        this.id = id;
        this.regionName = regionName;
        this.writerId = writerId;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }


    public String getRegionName() {
        return regionName;
    }


    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    @Override
    public String toString() {

        return "  " + id + " |  " + regionName + " | " + writerId;
    }
}
