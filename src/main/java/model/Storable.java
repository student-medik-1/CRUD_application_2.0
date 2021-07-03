package model;

public interface Storable {

    void setId(Long id);
    Long getId();
    void copyFrom(Storable storable);
}
