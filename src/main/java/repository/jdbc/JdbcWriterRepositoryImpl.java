package repository.jdbc;

import model.Post;
import model.Region;
import model.Writer;
import repository.WriterRepository;

import java.sql.*;
import java.util.*;

import static repository.jdbc.JdbcUtils.*;

public class JdbcWriterRepositoryImpl implements WriterRepository {

    private ResultSet resultSet;
    private PreparedStatement statement;


    @Override
    public Writer getById(Long id) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(WRITER_GET_BY_ID);
            statement.setLong(1,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Writer writer = new Writer();

        try {
            writer.setId(resultSet.getLong("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            writer.setPosts((List<Post>) resultSet.getObject("posts"));
            writer.setRegionName((Region) resultSet.getObject("region_name"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public Writer create(Writer writer) {


        try {
            statement = JdbcConnection.getConnection().prepareStatement(WRITER_CREATE);
            statement.setString(1, writer.getFirstName());
            statement.setString(2,writer.getLastName());
            statement.setObject(3,writer.getRegionName());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            writer.setId(resultSet.getLong("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            writer.setRegionName((Region) resultSet.getObject("region_name"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;

    }


    @Override
    public Writer update(Writer writer) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(WRITER_UPDATE);
            statement.setString(1, writer.getFirstName());
            statement.setString(2,writer.getLastName());
            statement.setObject(3,writer.getRegionName());
            statement.setLong(4,writer.getId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            writer.setId(resultSet.getLong("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            writer.setRegionName((Region) resultSet.getObject("region_name"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public void deleteById(Long id) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(WRITERS_DELETE);
            statement.setLong(1, id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public List<Writer> getAll() {

        List<Writer> writerList = new ArrayList<>();

        Statement statement = null;
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
                writer.setPosts((List<Post>) resultSet.getObject("posts"));
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
