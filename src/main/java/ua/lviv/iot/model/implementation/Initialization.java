package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

public class Initialization implements  IGeneralModel {
    private Integer id;
    private String login;
    private Integer user_id;
    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Initialization(Integer id, String login, Integer user_id) {
        this.id = id;
        this.login = login;
        this.user_id = user_id;
    }




    @Override
    public String toString() {
        return "Initialization{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}

