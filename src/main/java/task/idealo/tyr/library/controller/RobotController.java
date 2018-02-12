package task.idealo.tyr.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import task.idealo.tyr.library.core.enums.Direction;
import task.idealo.tyr.library.core.service.RobotService;
import task.idealo.tyr.library.core.dto.RobotReportDTO;
import task.idealo.tyr.library.core.enums.Rotation;

import static task.idealo.tyr.library.core.constants.Constants.*;

@RestController
public class RobotController {

    @Autowired
    private RobotService robotService;

    @RequestMapping(value = URL_ROBOT_PLACE, method = RequestMethod.POST)
    public void placeRobot(@RequestBody RequestRobotPlace request) {
        final Direction direction = Direction.fromAPICounterpart(request.getDirection());
        robotService.place(request.getPositionX(), request.getPositionY(), direction);
    }

    @RequestMapping(value = URL_ROBOT_REPORT, method = RequestMethod.GET)
    public ResponseGetRobotReport reportRobot() {
        final RobotReportDTO report = robotService.report();
        ResponseGetRobotReport response = new ResponseGetRobotReport();
        response.setDirection(report.getDirection().getApiCounterpart());
        response.setPositionX(report.getCoordinateX());
        response.setPositionY(report.getCoordinateY());
        return response;
    }

    @RequestMapping(value = URL_ROBOT_MOVE, method = RequestMethod.POST)
    public void moveRobot() {
        robotService.move();
    }

    @RequestMapping(value = URL_ROBOT_ROTATE, method = RequestMethod.POST)
    public void rotateRobot(@PathVariable(value = "rotation") String rotation) {
        robotService.rotate(Rotation.fromAPICounterpart(rotation));
    }

}
