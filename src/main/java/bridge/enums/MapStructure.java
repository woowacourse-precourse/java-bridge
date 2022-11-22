package bridge.enums;

public enum MapStructure {
    OPEN_BRACE("["),
    CLOSE_BRACE("]"),
    VERTICAL_BAR("|"),
    CORRECT(" O "),
    INCORRECT(" X "),
    WHITE_SPACE("   ");

    private final String part;

    MapStructure(String part) {
        this.part = part;
    }

    public String getPart() {
        return part;
    }

}
