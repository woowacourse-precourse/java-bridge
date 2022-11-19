package bridge.util;

public enum CharacterUnit {
    ENTER("\n");

    private final String unit;

    CharacterUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
