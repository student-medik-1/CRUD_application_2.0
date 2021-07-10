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


    @Override
    public Writer getById(Long id) {


        Writer writer = new Writer();


        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(WRITER_GET_BY_ID + id + " ;");

            writer.setId(resultSet.getLong(1));
            writer.setFirstName(resultSet.getString(2));
            writer.setLastName(resultSet.getString(3));
            writer.setRegionName((Region) resultSet.getObject(4));
            writer.setPosts((List<Post>) resultSet.getObject(5));

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return writer;
    }


    @Override
    public Writer create(Writer writer) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute("INSERT INTO practic.writers (first_name, last_name) " +
                    "VALUES('" + writer.getFirstName() + "' , '" + writer.getLastName() + "');");

            statement.execute("INSERT INTO practic.regions (writer_id) " +
                    "VALUES((SELECT MAX(id) FROM practic.writers)); ");

            statement.execute("INSERT INTO practic.posts (writer_id) " +
                    "VALUES((SELECT MAX(id) FROM practic.writers)); ");

            resultSet = statement.executeQuery(RESULT_WRITER_CREATE);


            if (resultSet.next()) {

                writer = new Writer(resultSet.getLong(1), writer.getFirstName(), writer.getLastName(),
                        (Region) resultSet.getObject(4),
                        (List<Post>) resultSet.getObject(5));
            }

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public Writer update(Writer writer) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute("UPDATE practic.writers SET first_name = " + writer.getFirstName() +
                    " , last_name = " + writer.getLastName() + "  WHERE id = " + writer.getId() + " ;");


            resultSet = statement.executeQuery(RESULT_WRITER_UPDATE + writer.getId() + ";");

            if (resultSet.next()) {

                writer = new Writer(writer.getId(),writer.getFirstName(), writer.getLastName(),
                        (Region) resultSet.getObject(4), (List<Post>) resultSet.getObject(5));

            }

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public void deleteById(Long id) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute(WRITER_DELETE + id + ";");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public List<Writer> getAll() {

        List<Writer> writerList = new ArrayList<>();

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(WRITER_GET_ALL);

            while (resultSet.next()) {

                Writer writer1 = new Writer(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), (Region) resultSet.getObject(4),
                        (List<Post>) resultSet.getObject(5));

                writerList.add(writer1);
            }

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writerList;
    }

}
