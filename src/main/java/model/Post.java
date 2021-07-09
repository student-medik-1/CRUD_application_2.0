package model;

public class Post {

    private Long id;
    private String content;
    private Writer writer;



    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }


    public Post(String content) {
        this.content = content;
    }


    public Post(Long id, String content) {
        this.id = id;
        this.content = content;

    }


    public Post (String content, Long writerId) {
        this.content = content;
        writer = new Writer(writerId);
    }


    public Post(Long id, String content, Long writerId) {
        this.id = id;
        this.content = content;
        writer = new Writer(writerId);
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Writer getWriter() {
        return writer;
    }


    public void setWriter(Writer writer) {
        this.writer = writer;
    }

}
