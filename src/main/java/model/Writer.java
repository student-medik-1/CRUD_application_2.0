package model;

import java.util.List;

public class Writer implements Storable{

    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Region regionName;


    public Writer(String firstName, String lastName, Region regionName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.regionName = regionName;
    }

    public Writer(Long id, String firstName, String lastName, List<Post> posts, Region regionName) {

        this(firstName, lastName, regionName);
        this.id = id;
        this.posts = posts;

    }


    @Override
    public void setId(Long id) {

        this.id = id;

    }

    @Override
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Region getRegionName() {
        return regionName;
    }

    public void setRegionName(Region regionName) {
        this.regionName = regionName;
    }



    @Override
    public void copyFrom(Storable storable) {

        Writer storableWriter = (Writer) storable;

        this.firstName = storableWriter.getFirstName();
        this.lastName = storableWriter.getLastName();
        this.posts = storableWriter.getPosts();
        this.regionName = storableWriter.getRegionName();
    }


    @Override
    public String toString() {

        StringBuilder postBuilder = new StringBuilder();

        if (posts != null && posts.size() > 0) {

            for (Post post : posts) {

                postBuilder.append(post).append(" ");

            }
        }
        return "Writer | "  + id + " | " + firstName +   " | " + lastName +
                " | " + regionName.getRegionName() + " | " + postBuilder.toString();
    }
}
