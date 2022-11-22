package bridge.generator;

public enum MapFormat {
    START("["),
    DIVIDE("|"),
    END("]"),
    NEW_LINE("\n");

    private final String format;

    MapFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return format;
    }
}
