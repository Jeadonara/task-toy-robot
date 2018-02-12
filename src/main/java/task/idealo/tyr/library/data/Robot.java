package task.idealo.tyr.library.data;

import task.idealo.tyr.library.core.constants.Constants;
import task.idealo.tyr.library.core.enums.Direction;

public class Robot {

    private final Table table;

    private Direction direction;

    private Integer coordinateX;

    private Integer coordinateY;

    private Robot(Table table) {
        this.table = table;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public Boolean setCoordinateXIfInTable(Integer coordinateX) {
        if (this.table.getWidth() >= coordinateX && coordinateX >= 0) {
            this.coordinateX = coordinateX;
            return true;
        } else return false;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public Boolean setCoordinateYIfInTable(Integer coordinateY) {
        if (this.table.getHeight() >= coordinateY && coordinateY >= 0) {
            this.coordinateY = coordinateY;
            return true;
        } else return false;
    }

    public Boolean isPlaced() {
        return this.direction != null && this.coordinateX != null && this.coordinateY != null;
    }

    /**
     * @return a Robot instance on table with default dimensions(5x5)
     */
    public static Robot getRobotInstance(){
        Table table = new Table(Constants.DEFAULT_TABLE_WIDTH,Constants.DEFAULT_TABLE_HEIGHT);
        return new Robot(table);
    }
}
