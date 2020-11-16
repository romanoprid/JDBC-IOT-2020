package ua.lviv.iot.DAO.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.model.implementation.Security;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SecurityDAO implements IGeneralDAO<Security, Integer> {

    private static final String GET_ALL = "SELECT * FROM roman_oprysk4.security";
    private static final String GET_BY_ID = "SELECT * FROM roman_oprysk4.security WHERE id=?";
    private static final String CREATE = "INSERT roman_oprysk4.security "
            + "(id, password, user_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE roman_oprysk4.security"
            + " SET password=? , user_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM roman_oprysk4.security WHERE id=?";

    @Override
    public final List<Security> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Security> securities = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String password = resultSet.getString(2);
                    Integer user_id = resultSet.getInt(3);
                    securities.add(new Security(id, password, user_id));
                }
            }
        }
        return securities;
    }

    @Override
    public final Security getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Security security = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String password = resultSet.getString(2);
                    Integer user_id = resultSet.getInt(3);
                    security = new Security(foundId, password, user_id);
                }
            }
        }

        return security;
    }

    @Override
    public final int create(final Security entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getPassword());
            ps.setInt(3, entity.getUser_id());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Security entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getPassword());
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