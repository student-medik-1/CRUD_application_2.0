package repository.jdbc.io;

import model.Region;
import repository.RegionRepository;
import repository.jdbc.JdbcConnection;
import util.IOUtil;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

import static repository.jdbc.JdbcUtils.*;

public class IORegionRepository implements RegionRepository {

    private final static String FILE_NAME = "src/main/resources/db.migration/regions.sql";

    public IORegionRepository() {

    }


    @Override
    public Region getById(Long id) {

        PreparedStatement statement = null;
        try {
            statement = JdbcConnection.getConnection().prepareStatement(REGION_GET_BY_ID);
            statement.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Region region = new Region();

        try {
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
    public void create(Region region) {

        PreparedStatement statement = null;
        try {
            statement = JdbcConnection.getConnection().prepareStatement(REGION_CREATE);
            statement.setString(1, region.getRegionName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Region region) {

        PreparedStatement statement = null;
        try {
            statement = JdbcConnection.getConnection().prepareStatement(REGION_UPDATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.setString(1, region.getRegionName());
            statement.setLong(2,region.getId());
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
    public void deleteById(Long id) {
        PreparedStatement statement = null;
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ResultSet resultSet = null;
        try {
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
