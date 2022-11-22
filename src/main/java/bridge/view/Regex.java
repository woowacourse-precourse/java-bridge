package bridge.view;

public enum Regex {
    RANGE("^[3-9]{1}$|^[1]{1}[0-9]{1}$|^20$"), MOVE("[UD]"), CONTINUE("[RQ]");

    private String pattern;

    Regex(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return this.pattern;
    }
}
