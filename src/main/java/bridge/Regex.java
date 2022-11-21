package bridge;

public enum Regex {
    MOVE("[UD]"), CONTINUE("[RQ]");

    private String pattern;

    Regex(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return this.pattern;
    }
}
