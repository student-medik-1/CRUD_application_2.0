package repository.jdbc;

import model.Region;
import repository.RegionRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
    public  Region create(Region region) {

        AtomicInteger id  = new AtomicInteger(0);

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute("INSERT INTO practic.regions (region_name,writer_id) " +
                    "VALUES( '" + region.getRegionName() + "' , " + region.getWriterId() + " );",
                    Statement.RETURN_GENERATED_KEYS);

             resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                id.set(resultSet.getInt(1));
            }

            resultSet = statement.executeQuery(RESULT_REGION_CREATE);



            if (resultSet.next()) {

                region = new Region((long) id.get(), resultSet.getString(2),
                        resultSet.getLong(3));

            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }


    @Override
    public Region update(Region region) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute("UPDATE practic.regions SET region_name = '" + region.getRegionName() +
                    "', writer_id = " + region.getWriterId() + " WHERE id = " + region.getId() + " ;");


            resultSet = statement.executeQuery(RESULT_REGION_UPDATE + region.getId() + " ;");

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
    public void deleteById(Long id) {

        try (Statement statement = JdbcConnection.getConnection().createStatement()) {

            statement.execute(REGION_DELETE + id + " ;");

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
