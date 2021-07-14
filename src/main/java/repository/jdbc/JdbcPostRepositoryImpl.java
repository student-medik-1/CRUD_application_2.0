package repository.jdbc;

import model.Post;
import repository.PostRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import static repository.jdbc.JdbcUtils.*;

public class JdbcPostRepositoryImpl implements PostRepository {

    private ResultSet resultSet;


    @Override
    public Post getById(Long id) {

        Post post = new Post();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(POST_GET_BY_ID + id + " ;");

            if (resultSet.next()) {

                if (resultSet.getObject(3) == null) {
                    post.setCreated(null);
                } else {
                    post.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                }

                if (resultSet.getObject(4) == null) {
                    post.setUpdated(null);
                } else {
                    post.setUpdated(resultSet.getTimestamp(4).toLocalDateTime());
                }

                post = new Post(resultSet.getLong(1), resultSet.getString(2),
                        post.getCreated(), post.getUpdated(), resultSet.getLong(5));
            }

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return post;
    }


    @Override
    public Post create(Long writer_id, String content) {

        Post post = new Post();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute("INSERT INTO practice.posts (content, created, writer_id) " +
                    "VALUES( '" + content + "' , \"" + Timestamp.valueOf(LocalDateTime.now()) +
                    "\", " + writer_id + ") ;");

            resultSet = statement.executeQuery(RESULT_POST_CREATE);

            if (resultSet.next()) {

                if (resultSet.getObject(3) == null) {
                    post.setCreated(null);
                } else {
                    post.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                }

                if (resultSet.getObject(4) == null) {
                    post.setUpdated(null);
                } else {
                    post.setUpdated(resultSet.getTimestamp(4).toLocalDateTime());
                }

                post = new Post(resultSet.getLong(1), resultSet.getString(2),
                        post.getCreated(), post.getUpdated(), resultSet.getLong(5));
            }

            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return post;
    }


    @Override
    public Post update(Long id, Long writer_id, String content) {

        Post post = new Post();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            if (statement.executeUpdate("UPDATE practice.posts SET content = '" + content + "'," +
                    "updated = \"" + Timestamp.valueOf(LocalDateTime.now()) + "\" , " +
                    "writer_id = " + writer_id + "  WHERE id = " + id + " ;") > 0) {

                resultSet = statement.executeQuery(RESULT_POST_UPDATE + id + " ;");

                if (resultSet.next()) {
                    if (resultSet.getObject(3) == null) {
                        post.setCreated(null);
                    } else {
                        post.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                    }

                    if (resultSet.getObject(4) == null) {
                        post.setUpdated(null);
                    } else {
                        post.setUpdated(resultSet.getTimestamp(4).toLocalDateTime());
                    }

                    post = new Post(resultSet.getLong(1), resultSet.getString(2),
                            post.getCreated(), post.getUpdated(), resultSet.getLong(5));
                }

                resultSet.close();

            } else {
                System.out.println("Не возможно изменить не существующую запись");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return post;
    }


    @Override
    public void deleteById(Long id) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            if (statement.executeUpdate(POST_DELETE + id + " ;") > 0) {

                System.out.println("... Данные удалены ...");
            } else {
                System.out.println("... Такой записи нет ...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Post> getAll() {

        List<Post> postList = new ArrayList<>();
        Post post = new Post();

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(POST_GET_ALL);

            while (resultSet.next()) {

                if (resultSet.getObject(3) == null) {
                    post.setCreated(null);
                } else {
                    post.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
                }

                if (resultSet.getObject(4) == null) {
                    post.setUpdated(null);
                } else {
                    post.setUpdated(resultSet.getTimestamp(4).toLocalDateTime());
                }

                post = new Post(resultSet.getLong(1), resultSet.getString(2),
                        post.getCreated(), post.getUpdated(), resultSet.getLong(5));

                postList.add(post);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postList;
    }

}
