package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

public class User implements IGeneralModel {
    private Integer id;
    private String name;
    private Integer birth_date;
    private Integer followers;
    private Integer followings;
    private Integer posts;

    public User(Integer id, String name, Integer birth_date, Integer followers, Integer followings, Integer posts) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.followers = followers;
        this.followings = followings;
        this.posts = posts;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Integer birth_date) {
        this.birth_date = birth_date;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowings() {
        return followings;
    }

    public void setFollowings(Integer followings) {
        this.followings = followings;
    }

    public Integer getPosts() {
        return posts;
    }

    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                ", followers=" + followers +
                ", followings=" + followings +
                ", posts=" + posts +
                '}';
    }
}