package task.idealo.tyr.library.controller;

import java.io.Serializable;

public class RequestRobotPlace implements Serializable{

    private Integer positionX;

    private Integer positionY;

    private String direction;

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
