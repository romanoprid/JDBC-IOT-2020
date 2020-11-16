package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.Security;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.SecurityService;

public class SecurityController extends GeneralController<Security> {

    private static final SecurityService SECURITY_SERVICE = new SecurityService();

    @Override
    public final GeneralService<Security> getService() {
        return SECURITY_SERVICE;
    }

}