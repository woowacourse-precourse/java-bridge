package bridge.EnumCollections;

public enum BridgeResultType {
    POSSIBLE("O", "성공"),
    IMPOSSIBLE("X", "실패"),
    NONE(" ", "");


    private String result;
    private String message;

    BridgeResultType(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }
    public String getMessage() {
        return message;
    }
}
