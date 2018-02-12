package task.idealo.tyr.library.core.enums;

public enum Direction {

    NORTH("north","North") {
        @Override
        public Direction rotateDirection(Rotation rotation) {
            return rotation == Rotation.LEFT ? WEST : EAST;
        }
    },
    SOUTH("south","South") {
        @Override
        public Direction rotateDirection(Rotation rotation) {
            return rotation == Rotation.LEFT ? EAST : WEST;
        }
    },
    EAST("east","East") {
        @Override
        public Direction rotateDirection(Rotation rotation) {
            return rotation == Rotation.LEFT ? NORTH : SOUTH;
        }
    },
    WEST("west","West") {
        @Override
        public Direction rotateDirection(Rotation rotation) {
            return rotation == Rotation.LEFT ? SOUTH : NORTH;
        }
    };

    private final String apiCounterpart;
    private final String name;

    Direction(String apiCounterpart, String name) {
        this.apiCounterpart = apiCounterpart;
        this.name = name;
    }

    public String getApiCounterpart() {
        return apiCounterpart;
    }

    public static Direction fromAPICounterpart(String apiCounterpart) {
        for (Direction value : Direction.values()) {
            if (value.getApiCounterpart().equals(apiCounterpart)) {
                return value;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public abstract Direction rotateDirection(Rotation rotation);

}
