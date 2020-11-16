package ua.lviv.iot.DAO.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.model.implementation.Story;
import ua.lviv.iot.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StoryDAO implements IGeneralDAO<Story, Integer> {

    private static final String GET_ALL = "SELECT * FROM roman_oprysk4.story";
    private static final String GET_BY_ID = "SELECT * FROM roman_oprysk4.story WHERE id=?";
    private static final String CREATE = "INSERT roman_oprysk4.story"
            + "(id, bloger, link, add_time, content, like_number, share_number) VALUES (?, ?, ?, ?, ?,?,?)";
    private static final String UPDATE = "UPDATE roman_oprysk4.story"
            + " SET bloger=?, link=?, add_time=?, content=?, like_number=?, share_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM roman_oprysk4.story WHERE id=?";

    @Override
    public final List<Story> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Story> stories = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String bloger = resultSet.getString(2);
                    String link = resultSet.getString(3);
                    Integer add_time = resultSet.getInt(4);
                    String content = resultSet.getString(5);
                    Integer like_number = resultSet.getInt(6);
                    Integer share_number = resultSet.getInt(7);
                    stories.add(new Story(id, bloger, link, add_time,content,like_number,share_number));
                }
            }
        }
        return stories;
    }


    @Override
    public final Story getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Story story = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String bloger = resultSet.getString(2);
                    String link = resultSet.getString(3);
                    Integer add_time = resultSet.getInt(4);
                    String content = resultSet.getString(5);
                    Integer like_number = resultSet.getInt(6);
                    Integer share_number = resultSet.getInt(7);
                    story = new Story(foundId, bloger, link, add_time, content,like_number, share_number);
                }
            }
        }

        return story;
    }

    @Override
    public final int create(final Story entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getBloger());
            ps.setString(3, entity.getLink());
            ps.setInt(4, entity.getAdd_time());
            ps.setString(5, entity.getContent());
            ps.setInt(6, entity.getLike_number());
            ps.setInt(7, entity.getShare_number());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Story entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getBloger());
            ps.setString(2, entity.getLink());
            ps.setInt(3, entity.getAdd_time());
            ps.setString(4, entity.getContent());
            ps.setInt(5, entity.getLike_number());
            ps.setInt(6, entity.getShare_number());
            ps.setInt(7, entity.getId());
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
