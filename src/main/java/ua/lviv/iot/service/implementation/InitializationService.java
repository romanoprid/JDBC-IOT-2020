package ua.lviv.iot.service.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.DAO.implementation.InitializationDAO;
import ua.lviv.iot.model.implementation.Initialization;

public class InitializationService extends GeneralService<Initialization> {
    private final IGeneralDAO<Initialization, Integer> initializationDAOImplementation = new InitializationDAO();

    @Override
    public final IGeneralDAO<Initialization, Integer> getDAO() {
        return initializationDAOImplementation;
    }
}
