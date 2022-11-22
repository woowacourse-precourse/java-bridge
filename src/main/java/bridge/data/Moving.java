package bridge.data;

public enum Moving {
    DOWN("D"),
    UP("U");

    private final String label;

    Moving(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
