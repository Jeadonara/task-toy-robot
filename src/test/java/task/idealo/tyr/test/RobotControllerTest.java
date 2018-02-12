package task.idealo.tyr.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import task.idealo.tyr.application.Application;
import task.idealo.tyr.library.controller.RequestRobotPlace;
import task.idealo.tyr.library.controller.RobotController;
import task.idealo.tyr.library.core.dto.RobotReportDTO;
import task.idealo.tyr.library.core.enums.Direction;
import task.idealo.tyr.library.core.enums.Rotation;
import task.idealo.tyr.library.core.service.RobotService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RobotController.class, secure = false)
@ContextConfiguration(classes = Application.class)
public class RobotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RobotService robotService;

    @Test
    public void testRobotPlace() throws Exception {
        RequestRobotPlace requestRobotPlace = new RequestRobotPlace();
        requestRobotPlace.setDirection(Direction.EAST.getApiCounterpart());
        requestRobotPlace.setPositionX(1);
        requestRobotPlace.setPositionY(2);
        mockMvc.perform(post("/robot/place").contentType(MediaType.APPLICATION_JSON).content(asJsonString(requestRobotPlace))).andExpect(status().isOk());
    }

    @Test
    public void testRobotReport() throws Exception {
        RobotReportDTO reportDTO = new RobotReportDTO();
        reportDTO.setDirection(Direction.EAST);
        reportDTO.setCoordinateY(5);
        reportDTO.setCoordinateX(1);
        given(robotService.report()).willReturn(reportDTO);
        mockMvc.perform(get("/robot/report").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.positionX").value(1))
                .andExpect(jsonPath("$.positionY").value(5))
                .andExpect(jsonPath("$.direction").value("east"));

    }


    @Test
    public void testRobotMove() throws Exception {
        mockMvc.perform(post("/robot/move")).andExpect(status().isOk());
    }

    @Test
    public void testRobotRotate() throws Exception {
        mockMvc.perform(post("/robot/rotate/" + Rotation.LEFT.getApiCounterpart())).andExpect(status().isOk());
        mockMvc.perform(post("/robot/rotate/" + Rotation.RIGHT.getApiCounterpart())).andExpect(status().isOk());

    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
