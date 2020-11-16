package ua.lviv.iot.service.implementation;


import ua.lviv.iot.DAO.IGeneralDAO;
import ua.lviv.iot.DAO.implementation.SecurityDAO;
import ua.lviv.iot.model.implementation.Security;

public class SecurityService extends GeneralService<Security> {
    private final IGeneralDAO<Security, Integer> securityDAOImplementation = new SecurityDAO();

    @Override
    public final IGeneralDAO<Security, Integer> getDAO() {
        return securityDAOImplementation;
    }
}