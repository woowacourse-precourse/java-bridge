package bridge.model;

public enum Boundary {
    MAP_START_BOUNDARY("["),
    MAP_MID_BOUNDARY("|"),
    MAP_END_BOUNDARY("]");

    private final String name;

    Boundary(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
