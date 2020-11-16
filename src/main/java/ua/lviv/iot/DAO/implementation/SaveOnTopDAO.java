package ua.lviv.iot.DAO.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.model.implementation.SaveOnTop;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SaveOnTopDAO implements IGeneralDAO<SaveOnTop, Integer> {

    private static final String GET_ALL = "SELECT * FROM roman_oprysk4.save_on_top";
    private static final String GET_BY_ID = "SELECT * FROM roman_oprysk4.save_on_top WHERE id=?";
    private static final String CREATE = "INSERT roman_oprysk4.save_on_top"
            + "(id, position , status, story_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE roman_oprysk4.save_on_top"
            + " SET position =?, status=?, story_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM roman_oprysk4.save_on_top WHERE id=?";




    @Override
    public final List<SaveOnTop> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<SaveOnTop> saveOnTops = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer position = resultSet.getInt(2);
                    String status = resultSet.getString(3);
                    Integer story_id = resultSet.getInt(4);
                    saveOnTops.add(new SaveOnTop(id, position, status,story_id));
                }
            }
        }
        return saveOnTops;
    }








    @Override
    public final SaveOnTop getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        SaveOnTop saveOnTop = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer position = resultSet.getInt(2);
                    String status = resultSet.getString(3);
                    Integer story_id = resultSet.getInt(4);
                    saveOnTop = new SaveOnTop(foundId,position, status, story_id);
                }
            }
        }

        return saveOnTop;
    }

    @Override
    public final int create(final SaveOnTop entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getPosition());
            ps.setString(3, entity.getStatus());
            ps.setInt(4, entity.getStory_id());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final SaveOnTop entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getPosition());
            ps.setString(2, entity.getStatus());
            ps.setInt(3, entity.getStory_id());
            ps.setInt(4, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}