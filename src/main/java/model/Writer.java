package model;

import java.util.List;

public class Writer{

    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Region regionName;

    public Writer() {
    }

    public Writer(Long id) {
        this.id = id;
    }

    public Writer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Writer(Long id, String firstName, String lastName) {
        this(firstName, lastName);
        this.id = id;
    }

    public Writer(Long id, String firstName, String lastName, List<Post> posts) {
        this(firstName, lastName);
        this.id = id;
        this.posts = posts;
    }

    public Writer(Long id, String firstName, String lastName,Region regionName, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.regionName = regionName;
        this.posts = posts;
    }


    public void setId(Long id) {
        this.id = id;
    }


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
    public String toString() {

        StringBuilder postBuilder = new StringBuilder();

        if (posts != null && posts.size() > 0) {

            for (Post post : posts) {
                postBuilder.append(post).append(" ");
            }
        } else {
            postBuilder.append("null");
        }

        return "Writer | "  + id + " | " + firstName +   " | " + lastName +
                " | " + regionName + " | " + postBuilder.toString();
    }
}
