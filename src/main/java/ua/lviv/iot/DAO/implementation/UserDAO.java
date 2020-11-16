package ua.lviv.iot.DAO.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.model.implementation.User;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAO implements IGeneralDAO<User, Integer> {

    private static final String GET_ALL = "SELECT * FROM roman_oprysk4.user";
    private static final String GET_BY_ID = "SELECT * FROM roman_oprysk4.user WHERE id=?";
    private static final String CREATE = "INSERT roman_oprysk4.user"
            + "(id, name , birth_date, followers, followings, posts) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE roman_oprysk4.user"
            + " SET  name=? , birth_date=?, followers=?, followings=?, posts=? WHERE id=?";
    private static final String DELETE = "DELETE FROM roman_oprysk4.user WHERE id=?";

    @Override
    public final List<User> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<User> users = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Integer birth_date = resultSet.getInt(3);
                    Integer followers = resultSet.getInt(4);
                    Integer followings = resultSet.getInt(5);
                    Integer posts = resultSet.getInt(6);
                    users.add(new User(id, name, birth_date, followers, followings, posts));
                }
            }
        }
        return users;
    }

    @Override
    public final User getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    Integer birth_date = resultSet.getInt(3);
                    Integer followers = resultSet.getInt(4);
                    Integer followings = resultSet.getInt(5);
                    Integer posts = resultSet.getInt(6);
                    user = new User(foundId, name, birth_date, followers, followings, posts);
                }
            }
        }

        return user;
    }

    @Override
    public final int create(final User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setInt(3, entity.getBirth_date());
            ps.setInt(4, entity.getFollowers());
            ps.setInt(5, entity.getFollowings());
            ps.setInt(6, entity.getPosts());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getBirth_date());
            ps.setInt(3, entity.getFollowers());
            ps.setInt(4, entity.getFollowings());
            ps.setInt(5, entity.getPosts());
            ps.setInt(6, entity.getId());
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

