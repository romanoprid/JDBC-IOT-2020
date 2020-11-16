package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.User;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.UserService;

public class UserController extends GeneralController<User> {

    private static final UserService USER_SERVICE = new UserService();

    @Override
    public final GeneralService<User> getService() {
        return USER_SERVICE;
    }

}
