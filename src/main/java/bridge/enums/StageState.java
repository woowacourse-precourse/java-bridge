package bridge.enums;

public enum StageState {
    PASS("통과"),
    NON_PASS("실패");

    private String description;

    StageState(String description) {
        this.description = description;
    }

    public boolean isPassed() {
        return this == PASS;
    }

}
