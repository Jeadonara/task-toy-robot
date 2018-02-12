package task.idealo.tyr.library.core.service;

import task.idealo.tyr.library.core.dto.RobotReportDTO;
import task.idealo.tyr.library.core.enums.Direction;
import task.idealo.tyr.library.core.enums.Rotation;

public interface RobotService {

    /**
     * @param positionX integer value to set position of Robot in x dimension
     * @param positionY integer value to set position of Robot in y dimension
     * @param direction integer value to set direction of Robot
     */
    void place(Integer positionX, Integer positionY, Direction direction);

    /**
     * @return RobotReportDTO instance that contains positionX,positionY and direction
     */
    RobotReportDTO report();

    /**
     * @param rotation updates the current direction of to robot
     */
    void rotate(Rotation rotation);

    /**
     * updated the current position one unit depending on the direction
     */
    void move();
}
