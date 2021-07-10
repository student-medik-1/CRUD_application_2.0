package repository.jdbc;

public class JdbcUtils {

    // for  Writer

    public static final String WRITER_GET_BY_ID = "SELECT writer_id,a.first_name,a.last_name, " +
            "a.region_name,content " +
            "FROM (SELECT writers.id, first_name, last_name, region_name " +
            "FROM practic.writers " +
            "LEFT JOIN practic.regions " +
            "ON practic.writers.id = practic.regions.writer_id) AS a  " +
            "LEFT JOIN practic.posts " +
            "ON a.id = practic.posts.writer_id  " +
            "WHERE a.id = ";

    public static final String RESULT_WRITER_CREATE = "SELECT a.id,a.first_name,a.last_name, " +
            "a.region_name,content " +
            "FROM (SELECT writers.id, first_name, last_name, region_name " +
            "FROM practic.writers " +
            "LEFT JOIN practic.regions " +
            "ON writers.id = regions.writer_id " +
            "WHERE writers.id = (SELECT MAX(id) " +
            "FROM practic.writers)) AS a " +
            "LEFT JOIN practic.posts " +
            "ON a.id = practic.posts.writer_id ";


    public static final String RESULT_WRITER_UPDATE = "SELECT writer_id,a.first_name,a.last_name, a.region_name,content"
            + " FROM (SELECT writers.id, first_name, last_name, region_name " +
            "FROM practic.writers " +
            "LEFT JOIN practic.regions " +
            "ON writers.id = regions.writer_id " +
            "WHERE writers.id = ? " +
            "FROM practic.writers)) AS a " +
            "LEFT JOIN posts " +
            "ON a.id = posts.writer_id" +
            "WHERE a.id = ";

    public static final String WRITER_GET_ALL = "SELECT writer_id,a.first_name,a.last_name, a.region_name, " +
            "content   FROM (SELECT writers.id, first_name, last_name, region_name " +
            "FROM practic.writers " +
            "LEFT JOIN practic.regions " +
            "ON practic.writers.id = practic.regions.writer_id) AS a " +
            "LEFT JOIN practic.posts " +
            "ON a.id = posts.writer_id;";

    public static final String WRITER_DELETE = "DELETE FROM writers WHERE id = ";


    // for  Post

    public static final String POST_GET_BY_ID = "SELECT id, content, created, updated FROM posts WHERE id= ? ;";
    public static final String POST_CREATE = "INSERT INTO posts (content, created, writer_id) VALUES(?,?,?) ;";
    public static final String POST_UPDATE = "UPDATE posts SET content = ?,updated = ?,writer_id = ? WHERE id = ?;";
    public static final String POST_GET_ALL = "SELECT id, content, created, updated FROM posts ;";
    public static final String POST_DELETE = "DELETE FROM posts WHERE id = ? ;";


    // for  Region

    public static final String REGION_GET_BY_ID = "SELECT * FROM practic.regions WHERE id= ";

    public static final String RESULT_REGION_CREATE = "SELECT region_name, writer_id FROM practic.regions " +
            "WHERE id =(SELECT MAX(id) FROM practic.regions)";

    public static final String RESULT_REGION_UPDATE = "SELECT * FROM practic.regions  WHERE id = ";

    public static final String REGION_GET_ALL = "SELECT * FROM practic.regions ;";

    public static final String REGION_DELETE = "DELETE FROM practic.regions WHERE id = ";

}
