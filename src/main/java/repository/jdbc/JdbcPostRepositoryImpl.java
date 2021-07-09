package repository.jdbc;

import model.Post;
import model.Writer;
import repository.PostRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import static repository.jdbc.JdbcUtils.*;

public class JdbcPostRepositoryImpl implements PostRepository {

    ResultSet resultSet;
    PreparedStatement statement;


    @Override
    public Post getById(Long id) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(POST_GET_BY_ID);
            statement.setLong(1,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Post post = new Post();

        try {
            resultSet = statement.executeQuery();

            post.setId(resultSet.getLong("id"));
            post.setContent(resultSet.getString("posts"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return post;
    }


    @Override
    public Post create(Post post) {

        Writer writer = new Writer();

        try {
            statement = JdbcConnection.getConnection().prepareStatement(POST_CREATE);
            statement.setString(1, post.getContent());
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.setLong(3,writer.getId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            resultSet = statement.executeQuery();

            post.setId(resultSet.getLong("id"));
            post.setContent(resultSet.getString("posts"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return post;
    }


    @Override
    public Post update(Post post) {

        Writer writer = new Writer();
        try {
            statement = JdbcConnection.getConnection().prepareStatement(POST_UPDATE);
            statement.setString(1, post.getContent());
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.setLong(3,writer.getId());
            statement.setLong(4,post.getId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery();

            post.setId(resultSet.getLong("id"));
            post.setContent(resultSet.getString("posts"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return post;
    }


    @Override
    public void deleteById(Long id) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(POST_DELETE);
            statement.setLong(1,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            statement.executeQuery();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public List<Post> getAll() {

        List<Post> postList = new ArrayList<>();

        Statement statement = null;
        try {
            statement = JdbcConnection.getConnection().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery(POST_GET_ALL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Post post = new Post();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }

                post.setId(resultSet.getLong("id"));
                post.setContent(resultSet.getString("content"));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            postList.add(post);
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return postList;
    }

}
