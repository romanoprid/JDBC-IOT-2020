package ua.lviv.iot.service.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.DAO.implementation.UserDAO;
import ua.lviv.iot.model.implementation.User;

public class UserService extends GeneralService<User> {
    private final IGeneralDAO<User, Integer> userDAOImplementation = new UserDAO();

    @Override
    public final IGeneralDAO<User, Integer> getDAO() {
        return userDAOImplementation;
    }
}
