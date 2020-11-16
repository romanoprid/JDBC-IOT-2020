package ua.lviv.iot.DAO.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.model.implementation.Initialization;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class InitializationDAO implements IGeneralDAO<Initialization, Integer> {

    private static final String GET_ALL = "SELECT * FROM roman_oprysk4.initialization";
    private static final String GET_BY_ID = "SELECT * FROM roman_oprysk4.initialization WHERE id=?";
    private static final String CREATE = "INSERT roman_oprysk4.initialization "
            + "(id, login, user_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE roman_oprysk4.initialization"
            + " SET login=?, user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM roman_oprysk4.initialization WHERE id=?";

    @Override
    public final List<Initialization> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Initialization> initializations = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String login = resultSet.getString(2);
                    Integer user_id = resultSet.getInt(3);
                    initializations.add(new Initialization(id, login, user_id));
                }
            }
        }
        return initializations;
    }

    @Override
    public final Initialization getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Initialization initialization = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String login = resultSet.getString(2);
                    Integer user_id = resultSet.getInt(3);
                    initialization = new Initialization(foundId, login, user_id);
                }
            }
        }

        return initialization;
    }

    @Override
    public final int create(final Initialization entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLogin());
            ps.setInt(3, entity.getUser_id());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Initialization entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getLogin());
            ps.setInt(2, entity.getUser_id());
            ps.setInt(3, entity.getId());
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
