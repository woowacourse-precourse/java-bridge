package bridge;

public enum BridgeStructure {

    START("[ "),
    TRUE("O"),
    SEPARATOR(" | "),
    END(" ]"),
    FALSE(" X ]");


    private final String structure;

    BridgeStructure(String structure) {
        this.structure = structure;
    }

    public String buildStructure() {
        return structure;
    }
}
