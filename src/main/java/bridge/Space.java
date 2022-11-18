package bridge;

public enum Space {
    DOWN(0, "D"), UP(1, "U");

    private final int index;
    private final String represented;

    Space(int index, String represented) {
        this.index = index;
        this.represented = represented;
    }

    public int getIndex() {
        return index;
    }

    public String getRepresented() {
        return represented;
    }
}
