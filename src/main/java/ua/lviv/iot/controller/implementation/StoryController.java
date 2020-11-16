package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.Story;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.StoryService;

public class StoryController extends GeneralController<Story> {

    private static final StoryService STORY_SERVICE = new StoryService();

    @Override
    public final GeneralService<Story> getService() {
        return STORY_SERVICE;
    }

}
