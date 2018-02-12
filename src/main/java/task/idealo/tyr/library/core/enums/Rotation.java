package task.idealo.tyr.library.core.enums;

public enum Rotation {

    LEFT("left"),
    RIGHT("right");

    private final String apiCounterpart;

    Rotation(String apiCounterpart) {
        this.apiCounterpart = apiCounterpart;
    }

    public String getApiCounterpart() {
        return apiCounterpart;
    }

    public static Rotation fromAPICounterpart(String apiCounterpart) {
        for (Rotation value : Rotation.values()) {
            if (value.getApiCounterpart().equals(apiCounterpart)) {
                return value;
            }
        }
        return null;
    }
}
