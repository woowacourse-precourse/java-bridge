package bridge.Constant;

public enum BridgeResult {
    SUCCESS("O"),
    FAIL("X"),
    NONE(" ");

    private final String Structure;

    BridgeResult(String Structure) {
        this.Structure = Structure;
    }

    public String getStructure() {
        return Structure;
    }
}
