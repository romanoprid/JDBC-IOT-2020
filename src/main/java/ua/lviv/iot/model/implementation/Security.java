package ua.lviv.iot.model.implementation;

import ua.lviv.iot.model.IGeneralModel;

public class Security implements IGeneralModel {
    private Integer id;
    private String password;
    private Integer user_id;

    public Security(Integer id, String password, Integer user_id) {
        this.id = id;
        this.password = password;
        this.user_id = user_id;
    }


    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}