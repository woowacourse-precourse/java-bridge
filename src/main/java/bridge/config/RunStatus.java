package bridge.config;

public enum RunStatus {

    ON(true),
    OFF(false);

    private final String RETRY = "R";

    private boolean status;

    private RunStatus(boolean status) {
        this.status = status;
    }

    public RunStatus getStatus(String result) {
        if (result.equals(RETRY)) {
            return ON;
        }
        return OFF;
    }

    public boolean isStatus() {
        return status;
    }

}
