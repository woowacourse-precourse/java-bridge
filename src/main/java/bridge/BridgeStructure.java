package bridge;

public enum BridgeStructure {

    FIRST_TRUE("[ O |"),
    MIDDLE_TRUE(" O |"),
    LAST_TRUE(" O ]"),

    FIRST_COLUMN("[ O ]"),
    UN_KNOWN("   |"),
    FALSE(" X ]");


    private final String structure;

    BridgeStructure(String structure) {
        this.structure = structure;
    }

    public String buildStructure() {
        return structure;
    }
}
