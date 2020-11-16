package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.SaveOnTop;

import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.SaveOnTopService;

public class SaveOnTopController extends GeneralController<SaveOnTop> {
    private static final SaveOnTopService SAVE_ON_TOP_SERVICE = new SaveOnTopService();


    @Override
    public final GeneralService<SaveOnTop> getService() {
        return SAVE_ON_TOP_SERVICE;
    }
}
