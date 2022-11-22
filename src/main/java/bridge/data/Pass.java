package bridge.data;

public enum Pass {
    YES(" O "),
    NO(" X "),
    NOTHING("   ");

    private final String label;

    Pass(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
