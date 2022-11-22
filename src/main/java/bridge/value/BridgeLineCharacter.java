package bridge.value;

public enum BridgeLineCharacter {

    MOVABLE_SQUARE(" O "),
    IMMOVABLE_SQUARE(" X "),
    EMPTY_SQUARE("   "),
    START_LINE("["),
    END_LINE("]"),
    BRIDGE_SEPARATOR("|");

    private final String character;

    BridgeLineCharacter(String character) {
        this.character = character;
    }

    public static BridgeLineCharacter characterFor(BridgeCharacter currCharacter, BridgeCharacter lineCharacter) {
        if (currCharacter == lineCharacter) {
            return MOVABLE_SQUARE;
        }
        return EMPTY_SQUARE;
    }

    public static BridgeLineCharacter resultCharacterFor(BridgeCharacter endCharacter, BridgeCharacter lineCharacter) {
        if (endCharacter != lineCharacter) {
            return IMMOVABLE_SQUARE;
        }
        return EMPTY_SQUARE;
    }

    public String getCharacter() {
        return character;
    }
}