package model;

import java.util.List;

public class Writer {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Region regionName;

    public Writer() {
    }


    public Writer(Long id, String firstName, String lastName, Region regionName, List<Post> posts) {
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
                postBuilder.append(post.getContent()).append(" ");
            }
        } else {
            postBuilder.append("null");
        }

        if(regionName != null) {
            return "  " + id + " | " + firstName + " | " + lastName +
                    " | " + regionName.getRegionName() + " | " + postBuilder.toString();
        } else {
            return "  " + id + " | " + firstName + " | " + lastName +
                    " | " + "null" + " | " + postBuilder.toString();
        }


    }
}
