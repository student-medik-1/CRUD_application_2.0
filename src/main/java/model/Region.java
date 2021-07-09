package model;

public class Region {

    private Long id;
    private String regionName;
    private Writer writer;


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


    public Region(String regionName,Long writerId) {
        this.regionName = regionName;
        writer = new Writer(writerId);
    }


    public Region(Long id, String regionName, Long writerId) {
        this.id = id;
        this.regionName = regionName;
        writer = new Writer(writerId);
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


    public Writer getWriter() {
        return writer;
    }


    public void setWriter(Writer writer) {
        this.writer = writer;
    }

}
