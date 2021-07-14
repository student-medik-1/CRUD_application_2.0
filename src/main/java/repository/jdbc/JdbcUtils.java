package repository.jdbc;

public class JdbcUtils {


    // for  Writer

    public static final String WRITER_GET_BY_ID = "SELECT writer_id,a.first_name,a.last_name, " +
            "a.region_name " +
            "FROM (SELECT writers.id, first_name, last_name, region_name " +
                  "FROM practice.writers " +
                      "LEFT JOIN practice.regions " +
                          "ON practice.writers.id = practice.regions.writer_id) AS a  " +
            "LEFT JOIN practice.posts " +
                "ON a.id = practice.posts.writer_id  " +
            "WHERE a.id = ";


    public static final String WRITER_GET_BY_ID_FOR_POSTS = "SELECT posts.content " +
            "FROM (SELECT practice.writers.id " +
                  "FROM practice.writers " +
                     "LEFT JOIN practice.regions " +
                        "ON practice.writers.id = practice.regions.writer_id) AS a  " +
            "LEFT JOIN practice.posts " +
                "ON  practice.posts.writer_id = a.id  " +
            "WHERE a.id = ";


    public static final String RESULT_WRITER_CREATE = "SELECT writer_id,a.first_name,a.last_name, " +
            "a.region_name " +
            "FROM (SELECT writers.id, first_name, last_name, region_name " +
                  "FROM practice.writers " +
                     "LEFT JOIN practice.regions " +
                        "ON writers.id = regions.writer_id " +
                     "WHERE writers.id = (SELECT MAX(id) " +
                                         "FROM practice.writers)) AS a " +
            "LEFT JOIN practice.posts " +
                 "ON a.id = practice.posts.writer_id ;";


    public static final String WRITER_CREATE_FOR_POSTS = "SELECT content " +
            "FROM (SELECT writers.id, first_name, last_name, region_name " +
                  "FROM practice.writers " +
                    "LEFT JOIN practice.regions " +
                       "ON writers.id = regions.writer_id " +
                    "WHERE writers.id = (SELECT MAX(id) " +
                                        "FROM practice.writers)) AS a " +
            "LEFT JOIN practice.posts " +
                 "ON practice.posts.writer_id = a.id ;";


    public static final String RESULT_WRITER_UPDATE = "SELECT writer_id,a.first_name,a.last_name, " +
            "a.region_name " +
            "FROM (SELECT writers.id, first_name, last_name, region_name " +
                          "FROM practice.writers " +
                            "LEFT JOIN practice.regions " +
                               "ON practice.writers.id = practice.regions.writer_id ) AS a " +
            "LEFT JOIN practice.posts " +
                "ON practice.posts.writer_id  = a.id " +
            "WHERE a.id = ";


    public static final String WRITER_UPDATE_FOR_POSTS = "SELECT content " +
            "FROM (SELECT writers.id, first_name, last_name, region_name " +
                  "FROM practice.writers " +
                    "LEFT JOIN practice.regions " +
                      "ON practice.writers.id = practice.regions.writer_id ) AS a " +
            "LEFT JOIN practice.posts " +
               "ON practice.posts.writer_id = a.id " +
            "WHERE a.id = ";


    public static final String WRITER_GET_ALL = "SELECT writer_id,a.first_name,a.last_name, a.region_name, " +
            "content   FROM (SELECT writers.id, first_name, last_name, region_name " +
                            "FROM practice.writers " +
                               "LEFT JOIN practice.regions " +
                                  "ON practice.writers.id = practice.regions.writer_id) AS a " +
            "LEFT JOIN practice.posts " +
               "ON practice.posts.writer_id = a.id ;";


    public static final String WRITER_DELETE = "DELETE " +
                                               "FROM practice.writers " +
                                               "WHERE id = ";


    public static final String DELETE_WRITER_ID_IN_POST = "DELETE " +
                                                          "FROM practice.posts " +
                                                          "WHERE writer_id = ";


    public static final String DELETE_WRITER_ID_IN_REGION = "DELETE " +
                                                            "FROM practice.regions " +
                                                            "WHERE writer_id = ";


    // for  Post

    public static final String POST_GET_BY_ID = "SELECT * " +
                                                "FROM practice.posts " +
                                                "WHERE id= ";


    public static final String RESULT_POST_CREATE = "SELECT * " +
                                                    "FROM practice.posts " +
                                                    "WHERE id = (SELECT MAX(id) " +
                                                                "FROM practice.posts) ;";


    public static final String RESULT_POST_UPDATE = "SELECT * " +
                                                    "FROM practice.posts  " +
                                                    "WHERE id = ";


    public static final String POST_GET_ALL = "SELECT *" +
                                              "FROM practice.posts ;";


    public static final String POST_DELETE = "DELETE " +
                                             "FROM practice.posts " +
                                             "WHERE id = ";


    // for  Region

    public static final String REGION_GET_BY_ID = "SELECT * " +
                                                  "FROM practice.regions " +
                                                  "WHERE id= ";


    public static final String RESULT_REGION_CREATE = "SELECT * " +
                                                      "FROM practice.regions " +
                                                      "WHERE id =(SELECT MAX(id) " +
                                                                 "FROM practice.regions) ;";


    public static final String RESULT_REGION_UPDATE = "SELECT * " +
                                                      "FROM practice.regions  " +
                                                      "WHERE id = ";


    public static final String REGION_GET_ALL = "SELECT * " +
                                                "FROM practice.regions ;";


    public static final String REGION_DELETE = "DELETE " +
                                               "FROM practice.regions " +
                                               "WHERE id = ";

}
