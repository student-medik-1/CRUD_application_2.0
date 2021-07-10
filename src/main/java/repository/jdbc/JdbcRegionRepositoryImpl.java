package repository.jdbc;

import model.Region;
import repository.RegionRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static repository.jdbc.JdbcUtils.*;

public class JdbcRegionRepositoryImpl implements RegionRepository {

    private ResultSet resultSet;

    @Override
    public Region getById(Long id) {

        Region region = new Region();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(REGION_GET_BY_ID + id + " ;");

            if (resultSet.next()) {
                region = new Region(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getLong(3));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }


    @Override
    public Region create(String regionName, Long writerId) {

        Region region = new Region();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute("INSERT INTO practic.regions (region_name,writer_id) " +
                    "VALUES( '" + regionName + "' , " + writerId + " );");

            resultSet = statement.executeQuery(RESULT_REGION_CREATE);

            if (resultSet.next()) {
                region = new Region(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getLong(3));
            }

            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }


    @Override
    public Region update(Long id, String regionName, Long writerId) {

        Region region = new Region();
        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            if (statement.executeUpdate("UPDATE practic.regions SET region_name = '" + regionName +
                    "', writer_id = " + writerId + " WHERE id = " + id + " ;") > 0) {

                resultSet = statement.executeQuery(RESULT_REGION_UPDATE + id + " ;");

                if (resultSet.next()) {
                    region = new Region(resultSet.getLong(1), resultSet.getString(2),
                            resultSet.getLong(3));
                }

                resultSet.close();

            } else {
                System.out.println("Не возможно изменить не существующую запись");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }


    @Override
    public void deleteById(Long id) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            if (statement.executeUpdate(REGION_DELETE + id + " ;") > 0) {

                System.out.println("... Данные удалены ...");
            } else {
                System.out.println("... Такой страны нет ...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Region> getAll() {

        List<Region> regionList = new ArrayList<>();

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            resultSet = statement.executeQuery(REGION_GET_ALL);

            while (resultSet.next()) {
                Region region = new Region(resultSet.getLong(1),
                        resultSet.getString(2), resultSet.getLong(3));

                regionList.add(region);
            }

            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return regionList;
    }

}
