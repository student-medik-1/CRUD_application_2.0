package repository.jdbc;

import model.Post;
import model.Region;
import model.Writer;
import repository.WriterRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import static repository.jdbc.JdbcUtils.*;

public class JdbcWriterRepositoryImpl implements WriterRepository {

    private ResultSet resultSet;


    @Override
    public Writer getById(Long id) {

        Writer writer = new Writer();
        List<Post> postList = new ArrayList<>();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(WRITER_GET_BY_ID + id + " ;");

            if (resultSet.next()) {
                postList.add(new Post(resultSet.getString(5)));

                if (resultSet.getString(4) == null) {
                    writer.setRegionName(new Region("null"));
                } else {
                    writer.setRegionName(new Region(resultSet.getString(4)));
                }


                writer = new Writer(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), writer.getRegionName(),
                        postList);
            }

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public Writer create(String firstName, String lastName) {

        Writer writer = new Writer();
        List<Post> postList = new ArrayList<>();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute("INSERT INTO practic.writers (first_name, last_name) " +
                    "VALUES('" + firstName + "' , '" + lastName + "');");

            statement.execute("INSERT INTO practic.regions (writer_id) " +
                    "VALUES((SELECT MAX(id) FROM practic.writers)); ");

            statement.execute("INSERT INTO practic.posts (created, writer_id) " +
                    "VALUES( \"" + Timestamp.valueOf(LocalDateTime.now()) + "\" ," +
                    "(SELECT MAX(id) FROM practic.writers)); ");

            resultSet = statement.executeQuery(RESULT_WRITER_CREATE);

            if (resultSet.next()) {

                postList.add(new Post(resultSet.getString(5)));
                if (resultSet.getString(4) == null) {
                    writer.setRegionName(new Region("регион не указан"));
                } else {
                    writer.setRegionName(new Region(resultSet.getString(4)));
                }


                writer = new Writer(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), writer.getRegionName(), postList);
            }

            resultSet.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public Writer update(Long id, String firstName, String lastName) {

        Writer writer = new Writer();
        List<Post> postList = new ArrayList<>();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            if (statement.executeUpdate("UPDATE practic.writers SET first_name = '" + firstName +
                    "' , last_name = '" + lastName + "'  WHERE id = " + id + " ;") > 0) {

                resultSet = statement.executeQuery(RESULT_WRITER_UPDATE + id);

                if (resultSet.next()) {

                    postList.add(new Post(resultSet.getString(5)));

                    if (resultSet.getString(4) == null) {
                        writer.setRegionName(new Region("регион не указан"));
                    } else {
                        writer.setRegionName(new Region(resultSet.getString(4)));
                    }


                    writer = new Writer(resultSet.getLong(1), resultSet.getString(2),
                            resultSet.getString(3), writer.getRegionName(), postList);
                }

                resultSet.close();

            } else {
                System.out.println("Не возможно изменить не существующую запись");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writer;
    }


    @Override
    public void deleteById(Long id) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            if (statement.executeUpdate(WRITER_DELETE + id + ";") > 0) {

                if (statement.executeUpdate(DELETE_WRITER_ID_IN_POST + id + " ;") > 0) {
                    System.out.println("... ID  писателя в папке пост удален ...");

                    if (statement.executeUpdate(DELETE_WRITER_ID_IN_REGION + id + " ;") > 0) {
                        System.out.println("... ID  писателя в папке регион удален ...");

                    } else {
                        System.out.println("... ID  писателя в папке регион не существует ...");
                    }

                } else {
                    System.out.println("... ID  писателя в папке пост не существует ...");
                }

                System.out.println("... Данные удалены ...");
            } else {
                System.out.println("... Такого писателя нет ...");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public List<Writer> getAll() {

        List<Writer> writerList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();


        // для отслежения повторных ID
        Set<Long> idSet = new HashSet<>();
        List<Long> idList = new LinkedList<>();

        Writer writer = new Writer();

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(WRITER_GET_ALL);

            while (resultSet.next()) {

                // одноразовый постлист
                List<Post> posts = new ArrayList<>();

                if (resultSet.getString(4) == null) {
                    writer.setRegionName(new Region("регион не указан"));
                } else {
                    writer.setRegionName(new Region(resultSet.getString(4)));
                }

                // поиск двух или нескольких постов у одного писателя
                if (idSet.add(resultSet.getLong(1))) {

                    idList.add(resultSet.getLong(1));

                    postList.add(new Post(resultSet.getString(5)));
                    posts.add(new Post(resultSet.getString(5)));

                    writer = new Writer(resultSet.getLong(1), resultSet.getString(2),
                            resultSet.getString(3), writer.getRegionName(), posts);


                    writerList.add(writer);

                } else {

                    int indexDuplicateId = idList.indexOf(resultSet.getLong(1));

                    posts.add(postList.get(indexDuplicateId));
                    posts.add(new Post(resultSet.getString(5)));

                    writer = new Writer(resultSet.getLong(1), resultSet.getString(2),
                            resultSet.getString(3), writer.getRegionName(), posts);


                    writerList.set(indexDuplicateId, writer);
                }

            }

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return writerList;
    }

}
