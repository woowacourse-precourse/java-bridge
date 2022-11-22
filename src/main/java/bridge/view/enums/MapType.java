package bridge.view.enums;

public enum MapType {
    START("["),
    DIVISION("|"),
    END("]"),
    EMPTY("   "),
    CAN_STEP(" O "),
    CAN_NOT_STEP(" X ");

    private final String type;

    MapType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}