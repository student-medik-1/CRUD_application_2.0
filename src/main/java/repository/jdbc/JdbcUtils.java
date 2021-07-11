package repository.jdbc;

public class JdbcUtils {

    // for  Writer

    public static final String WRITER_GET_BY_ID = "SELECT DISTINCT writer_id,a.first_name,a.last_name, " +
            "a.region_name,content " +
            "FROM (SELECT DISTINCT writers.id, first_name, last_name, region_name " +
                  "FROM practic.writers " +
                      "LEFT JOIN practic.regions " +
                          "ON practic.writers.id = practic.regions.writer_id) AS a  " +
            "LEFT JOIN practic.posts " +
                "ON a.id = practic.posts.writer_id  " +
            "WHERE a.id = ";

    public static final String RESULT_WRITER_CREATE = "SELECT DISTINCT writer_id,a.first_name,a.last_name, " +
            "a.region_name,content " +
            "FROM (SELECT DISTINCT writers.id, first_name, last_name, region_name " +
                  "FROM practic.writers " +
                     "LEFT JOIN practic.regions " +
                        "ON writers.id = regions.writer_id " +
                     "WHERE writers.id = (SELECT MAX(id) " +
                                         "FROM practic.writers)) AS a " +
            "LEFT JOIN practic.posts " +
                 "ON a.id = practic.posts.writer_id ;";


    public static final String RESULT_WRITER_UPDATE = "SELECT DISTINCT writer_id,a.first_name,a.last_name, " +
            "a.region_name,content " +
            "FROM (SELECT DISTINCT writers.id, first_name, last_name, region_name " +
                          "FROM practic.writers " +
                            "LEFT JOIN practic.regions " +
                               "ON practic.writers.id = practic.regions.writer_id ) AS a " +
            "LEFT JOIN practic.posts " +
                "ON a.id = practic.posts.writer_id " +
              "WHERE a.id = ";

    public static final String WRITER_GET_ALL = "SELECT DISTINCT writer_id,a.first_name,a.last_name, a.region_name, " +
            "content   FROM (SELECT DISTINCT writers.id, first_name, last_name, region_name " +
                            "FROM practic.writers " +
                               "LEFT JOIN practic.regions " +
                                  "ON practic.writers.id = practic.regions.writer_id) AS a " +
            "LEFT JOIN practic.posts " +
            "ON a.id = posts.writer_id;";

    public static final String WRITER_DELETE = "DELETE " +
                                               "FROM practic.writers " +
                                               "WHERE id = ";

    public static final String DELETE_WRITER_ID_IN_POST = "DELETE " +
                                                          "FROM practic.posts " +
                                                          "WHERE writer_id = ";

    public static final String DELETE_WRITER_ID_IN_REGION = "DELETE " +
                                                            "FROM practic.regions " +
                                                            "WHERE writer_id = ";


    // for  Post

    public static final String POST_GET_BY_ID = "SELECT * " +
                                                "FROM practic.posts " +
                                                "WHERE id= ";

    public static final String RESULT_POST_CREATE = "SELECT * " +
                                                    "FROM practic.posts " +
                                                    "WHERE id = (SELECT MAX(id) " +
                                                                "FROM practic.posts) ;";

    public static final String RESULT_POST_UPDATE = "SELECT * " +
                                                    "FROM practic.posts  " +
                                                    "WHERE id = ";

    public static final String POST_GET_ALL = "SELECT *" +
                                              "FROM practic.posts ;";

    public static final String POST_DELETE = "DELETE " +
                                             "FROM practic.posts " +
                                             "WHERE id = ";


    // for  Region

    public static final String REGION_GET_BY_ID = "SELECT * " +
                                                  "FROM practic.regions " +
                                                  "WHERE id= ";

    public static final String RESULT_REGION_CREATE = "SELECT * " +
                                                      "FROM practic.regions " +
                                                      "WHERE id =(SELECT MAX(id) " +
                                                                 "FROM practic.regions) ;";

    public static final String RESULT_REGION_UPDATE = "SELECT * " +
                                                      "FROM practic.regions  " +
                                                      "WHERE id = ";

    public static final String REGION_GET_ALL = "SELECT * " +
                                                "FROM practic.regions ;";

    public static final String REGION_DELETE = "DELETE " +
                                               "FROM practic.regions " +
                                               "WHERE id = ";

}
