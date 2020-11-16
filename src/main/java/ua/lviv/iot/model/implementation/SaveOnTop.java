package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

public class SaveOnTop implements IGeneralModel {
    private Integer id;
    private Integer position;
    private String status;
    private Integer story_id;

    public SaveOnTop(Integer id, Integer position, String status, Integer story_id) {
        this.id = id;
        this.position = position;
        this.status = status;
        this.story_id = story_id;
    }




    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStory_id() {
        return story_id;
    }

    public void setStory_id(Integer story_id) {
        this.story_id = story_id;
    }


    @Override
    public String toString() {
        return "SaveOnTop{" +
                "id=" + id +
                ", position=" + position +
                ", status='" + status + '\'' +
                ", story_id=" + story_id +
                '}';
    }
}
