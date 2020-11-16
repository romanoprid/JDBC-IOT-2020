package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.Initialization;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.InitializationService;

public class InitializationController extends GeneralController<Initialization> {

    private static final InitializationService INITIALIZATION_SERVICE = new InitializationService();

    @Override
    public final GeneralService<Initialization> getService() {
        return INITIALIZATION_SERVICE;
    }

}
