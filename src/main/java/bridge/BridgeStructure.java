package bridge;

public enum BridgeStructure {


    TRUE(" O |"),
    SEPARATOR("   |"),

    FALSE(" X ]");


    private final String structure;

    BridgeStructure(String structure) {
        this.structure = structure;
    }

    public String buildStructure() {
        return structure;
    }
}
