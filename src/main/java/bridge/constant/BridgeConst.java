package bridge.constant;

public enum BridgeConst {

    SUCCESS("성공")
    , FAILURE("실패")
    , POSSIBLE("O")
    , IMPOSSIBLE("X")
    ;

    private final String identifier;

    BridgeConst(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
