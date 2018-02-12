package task.idealo.tyr.library.core.exception;

public class TYRError {

    public static TYRError ERROR_INVALID_PARAMETER = new TYRError("Parameter {0} cannot be null or empty.");
    public static TYRError ERROR_INVALID_POSITION = new TYRError("The value {0} for {1} is not valid, must be less/equal than {2} and greater/equal than {3}");
    public static TYRError ROBOT_IS_NOT_PLACED = new TYRError("To make any action, robot must be placed first");
    public static TYRError CAN_NOT_MOVE = new TYRError(" Robot at x: {0}, y:{1} can not move. Direction must be changed, current direction is {2}");
    public static TYRError GENERIC = new TYRError("{0}");

    private String pattern;

    private TYRError(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
