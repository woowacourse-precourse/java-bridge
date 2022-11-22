package bridge.utils.enums;

public enum RetryFormat {
    RETRY("R"),
    QUIT("Q");

    private final String label;

    RetryFormat(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isEqual(String label) {
        return this.label.equals(label);
    }
}
