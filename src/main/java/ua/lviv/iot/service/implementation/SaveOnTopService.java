package ua.lviv.iot.service.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.DAO.implementation.SaveOnTopDAO;
import ua.lviv.iot.model.implementation.SaveOnTop;

public class SaveOnTopService extends GeneralService<SaveOnTop> {
    private final IGeneralDAO<SaveOnTop, Integer> saveOnTopDAOImplementation = new SaveOnTopDAO();

    @Override
    public final IGeneralDAO<SaveOnTop, Integer> getDAO() {
        return saveOnTopDAOImplementation;
    }
}
