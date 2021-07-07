package repository.jdbc;

import model.Region;
import repository.RegionRepository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static repository.jdbc.JdbcUtils.*;

public class JdbcRegionRepositoryImpl implements RegionRepository {

    private ResultSet resultSet;
    private PreparedStatement statement;


    @Override
    public Region getById(Long id) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(REGION_GET_BY_ID);
            statement.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Region region = new Region();

        try {
            resultSet = statement.executeQuery();
            region.setId(resultSet.getLong("id"));
            region.setRegionName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }


    @Override
    public Region create(Region region) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(REGION_CREATE);
            statement.setString(1, region.getRegionName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery();

            region.setId(resultSet.getLong("id"));
            region.setRegionName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }


    @Override
    public Region update(Region region) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(REGION_UPDATE);

            statement.setString(1, region.getRegionName());
            statement.setLong(2,region.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet = statement.executeQuery();

            region.setId(resultSet.getLong("id"));
            region.setRegionName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return region;
    }


    @Override
    public void deleteById(Long id) {

        try {
            statement = JdbcConnection.getConnection().prepareStatement(REGION_DELETE);
            statement.setLong(1, id);
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
    public List<Region> getAll() {

        List<Region> regionList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = JdbcConnection.getConnection().createStatement();
            resultSet = statement.executeQuery(REGION_GET_ALL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Region region = new Region();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }

                region.setId(resultSet.getLong("id"));
                region.setRegionName(resultSet.getString("name"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            regionList.add(region);
        }

        try {
            resultSet.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return regionList;
    }

}
