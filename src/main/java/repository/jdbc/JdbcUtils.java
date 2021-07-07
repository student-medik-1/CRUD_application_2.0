package repository.jdbc;

public class JdbcUtils {

    // for package Writer

    public static final String WRITER_GET_BY_ID = "SELECT * FROM writers WHERE id= ?";
    public static final String WRITER_CREATE = "INSERT INTO writers (first_name, last_name, region_name) " +
            "VALUES(?,?,?)";
    public static final String WRITER_UPDATE = "UPDATE writers SET first_name = ?, last_name = ?, region_name = ?"
                                      + "WHERE id = ?";
    public static final String WRITER_GET_ALL = "SELECT * FROM writers";
    public static final String WRITERS_DELETE = "DELETE FROM writers WHERE id = ?";


    // for package Post

    public static final String POST_GET_BY_ID = "SELECT * FROM posts WHERE id= ?";
    public static final String POST_CREATE = "INSERT INTO posts (content, created) VALUES(?,?)";
    public static final String POST_UPDATE = "UPDATE posts SET content = ?, updated = ?  WHERE id = ?";
    public static final String POST_GET_ALL = "SELECT * FROM posts";
    public static final String POST_DELETE = "DELETE FROM posts WHERE id = ?";


    // for package Region

    public static final String REGION_GET_BY_ID = "SELECT * FROM regions WHERE id= ?";
    public static final String REGION_CREATE = "INSERT INTO regions (region_name) VALUES(?)";
    public static final String REGION_UPDATE = "UPDATE regions SET region_name = ? WHERE id = ?";
    public static final String REGION_GET_ALL = "SELECT * FROM regions";
    public static final String REGION_DELETE = "DELETE FROM regions WHERE id = ?";

}
