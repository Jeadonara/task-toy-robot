package task.idealo.tyr.library.core.service;

import org.springframework.stereotype.Service;
import task.idealo.tyr.library.core.dto.RobotReportDTO;
import task.idealo.tyr.library.core.enums.Direction;
import task.idealo.tyr.library.core.enums.Rotation;
import task.idealo.tyr.library.core.utils.ValidationUtils;
import task.idealo.tyr.library.data.Robot;
import task.idealo.tyr.library.core.exception.TYRError;

import static task.idealo.tyr.library.core.constants.Constants.*;

@Service
public class DefaultRobotService implements RobotService {

    private final Robot robot = Robot.getRobotInstance();

    @Override
    public void place(Integer positionX, Integer positionY, Direction direction) {
        ValidationUtils.validateNotNull(positionX, TYRError.ERROR_INVALID_PARAMETER, "positionX");
        ValidationUtils.assertTrue(positionX >= 0 && positionX <= DEFAULT_TABLE_WIDTH, TYRError.ERROR_INVALID_POSITION, positionX.toString(), "positionX", String.valueOf(DEFAULT_TABLE_WIDTH), "0");
        ValidationUtils.validateNotNull(positionY, TYRError.ERROR_INVALID_PARAMETER, "positionY");
        ValidationUtils.assertTrue(positionY >= 0 && positionY <= DEFAULT_TABLE_HEIGHT, TYRError.ERROR_INVALID_POSITION, positionY.toString(), "positionY", String.valueOf(DEFAULT_TABLE_HEIGHT), "0");
        ValidationUtils.validateNotNull(direction, TYRError.GENERIC, "direction parameter can not be null or empty, must be one of: north,south,west,east");
        robot.setCoordinateXIfInTable(positionX);
        robot.setCoordinateYIfInTable(positionY);
        robot.setDirection(direction);
    }

    @Override
    public RobotReportDTO report() {
        ValidationUtils.assertTrue(robot.isPlaced(), TYRError.ROBOT_IS_NOT_PLACED);
        RobotReportDTO reportDTO = new RobotReportDTO();
        reportDTO.setDirection(robot.getDirection());
        reportDTO.setCoordinateX(robot.getCoordinateX());
        reportDTO.setCoordinateY(robot.getCoordinateY());
        return reportDTO;
    }

    @Override
    public void rotate(Rotation rotation) {
        ValidationUtils.validateNotNull(rotation, TYRError.GENERIC, "rotation parameter can not be null or empty, must be left or right");
        ValidationUtils.assertTrue(robot.isPlaced(), TYRError.ROBOT_IS_NOT_PLACED);
        Direction rotatedDirection = robot.getDirection().rotateDirection(rotation);
        robot.setDirection(rotatedDirection);
    }

    @Override
    public void move() {
        ValidationUtils.assertTrue(robot.isPlaced(), TYRError.ROBOT_IS_NOT_PLACED);
        Boolean isRobotPositionUpdated;
        switch (robot.getDirection()) {
            case NORTH:
                isRobotPositionUpdated = robot.setCoordinateYIfInTable(robot.getCoordinateY() + 1);
                break;
            case SOUTH:
                isRobotPositionUpdated = robot.setCoordinateYIfInTable(robot.getCoordinateY() - 1);
                break;
            case EAST:
                isRobotPositionUpdated = robot.setCoordinateXIfInTable(robot.getCoordinateX() + 1);
                break;
            case WEST:
                isRobotPositionUpdated = robot.setCoordinateXIfInTable(robot.getCoordinateX() - 1);
                break;
            default:
                isRobotPositionUpdated = Boolean.FALSE;
                break;
        }
        ValidationUtils.assertTrue(isRobotPositionUpdated, TYRError.CAN_NOT_MOVE, robot.getCoordinateX().toString(), robot.getCoordinateY().toString(), robot.getDirection().getName());
    }
}
