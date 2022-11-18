package bridge.EnumCollections;

public enum BridgeResultType {
    POSSIBLE("O"),
    IMPOSSIBLE("X"),
    NONE("");


    private String result;

    BridgeResultType(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
