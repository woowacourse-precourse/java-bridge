package bridge.model;

public class MoveRecord {
    private final String step;
    private final boolean success;

    private MoveRecord(String step, boolean success) {
        this.step = step;
        this.success = success;
    }

    public static MoveRecord addRecord(String step, boolean success) {
        return new MoveRecord(step, success);
    }

    public String getStep() {
        return step;
    }

    public boolean isSuccess() {
        return success;
    }
}
