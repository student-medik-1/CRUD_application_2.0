package repository.jdbc;

import model.Post;
import model.Region;
import model.Writer;
import repository.WriterRepository;

import java.sql.*;
import java.util.*;

import static repository.jdbc.JdbcUtils.*;

public class JdbcWriterRepositoryImpl implements WriterRepository {

    private PreparedStatement preparedStatement;
    private Statement statement;
    ResultSet resultSet;


    @Override
    public Writer getById(Long id) {

        try {
            preparedStatement = JdbcConnection.getConnection().prepareStatement(WRITER_GET_BY_ID);
            preparedStatement.setLong(1,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Writer writer = new Writer();

        try {
            writer.setId(resultSet.getLong("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            writer.setPosts((List<Post>) resultSet.getObject("content"));
            writer.setRegionName((Region) resultSet.getObject("region_name"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public Writer create(Writer writer) {

        String firstName =  "'" + writer.getFirstName() + "'";
        String lastName = "'" + writer.getLastName() + "'";

        try {
            preparedStatement = JdbcConnection.getConnection().prepareStatement(WRITER_CREATE);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2,lastName);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try (Statement statement = JdbcConnection.getConnection().createStatement()){

            resultSet = statement.executeQuery(RESULT_WRITER_CREATE);

            if (resultSet.next()) {

                writer.setId(Long.valueOf(resultSet.getString(1)));
                writer.setFirstName(resultSet.getString(2));
                writer.setLastName(resultSet.getString(3));
                writer.setRegionName((Region) resultSet.getObject(4));
                writer.setPosts((List<Post>) resultSet.getObject(5));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public Writer update(Writer writer) {

        try {
            preparedStatement = JdbcConnection.getConnection().prepareStatement(WRITER_UPDATE);
            preparedStatement.setString(1, writer.getFirstName());
            preparedStatement.setString(2,writer.getLastName());
            preparedStatement.setLong(3,writer.getId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet = preparedStatement.executeQuery();

            writer.setId(resultSet.getLong("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            writer.setPosts((List<Post>) resultSet.getObject("content"));
            writer.setRegionName((Region) resultSet.getObject("region_name"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public void deleteById(Long id) {

        try {
            preparedStatement = JdbcConnection.getConnection().prepareStatement(WRITER_DELETE);
            preparedStatement.setLong(1, id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public List<Writer> getAll() {

        List<Writer> writerList = new ArrayList<>();


        try {
            statement = JdbcConnection.getConnection().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery(WRITER_GET_ALL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Writer writer = new Writer();

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }

                writer.setId(resultSet.getLong("id"));
                writer.setFirstName(resultSet.getString("first_name"));
                writer.setLastName(resultSet.getString("last_name"));
                writer.setPosts((List<Post>) resultSet.getObject("content"));
                writer.setRegionName((Region) resultSet.getObject("region_name"));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            writerList.add(writer);
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writerList;
    }

}
