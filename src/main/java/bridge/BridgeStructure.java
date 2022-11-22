package bridge;

public enum BridgeStructure {

    UN_KNOWN("    |"),
    TRUE(" O |"),
    FALSE(" X |");


    private String structure;

    BridgeStructure(String structure) {
        this.structure = structure;
    }

    public String buildStructure() {
        return structure;
    }
}
