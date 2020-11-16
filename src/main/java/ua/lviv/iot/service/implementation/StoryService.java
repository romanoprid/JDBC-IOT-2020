package ua.lviv.iot.service.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.DAO.implementation.StoryDAO;
import ua.lviv.iot.model.implementation.Story;

public class StoryService extends GeneralService<Story> {
    private final IGeneralDAO<Story, Integer> storyDAOImplementation = new StoryDAO();

    @Override
    public final IGeneralDAO<Story, Integer> getDAO() {
        return storyDAOImplementation;
    }
}