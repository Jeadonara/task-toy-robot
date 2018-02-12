package task.idealo.tyr.library.core.dto;

import task.idealo.tyr.library.core.enums.Direction;

public class RobotReportDTO {

    private  Direction direction;

    private  Integer coordinateX;

    private  Integer coordinateY;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }
}
