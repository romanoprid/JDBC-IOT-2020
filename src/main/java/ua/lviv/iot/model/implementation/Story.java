package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

public class Story implements IGeneralModel {
    private Integer id;
    private String bloger;
    private String link;
    private Integer add_time;
    private String content;
    private Integer like_number;
    private Integer share_number;

    public Story(Integer id, String bloger, String link, Integer add_time, String content, Integer like_number,
                 Integer share_number) {
        this.id = id;
        this.bloger = bloger;
        this.link = link;
        this.add_time = add_time;
        this.content = content;
        this.like_number = like_number;
        this.share_number = share_number;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBloger() {
        return bloger;
    }

    public void setBloger(String bloger) {
        this.bloger = bloger;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Integer add_time) {
        this.add_time = add_time;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }





    public Integer getLike_number() {
        return like_number;
    }

    public void setLike_number(Integer like_number) {
        this.like_number = like_number;
    }

    public Integer getShare_number() {
        return share_number;
    }

    public void setShare_number(Integer share_number) {
        this.share_number = share_number;
    }


    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", bloger='" + bloger + '\'' +
                ", link='" + link + '\'' +
                ", add_time=" + add_time +
                ", content='" + content + '\'' +
                ", like_number=" + like_number +
                ", share_number=" + share_number +
                '}';
    }
}