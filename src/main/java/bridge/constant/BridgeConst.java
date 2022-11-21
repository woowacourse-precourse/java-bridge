package bridge.constant;

public enum BridgeConst {

    SUCCESS("성공")
    , FAILURE("실패")
    , POSSIBLE(" O ")
    , IMPOSSIBLE(" X ")
    , MAP_START("[")
    , MAP_END("]")
    , MAP_SEPARATOR("|")
    , MAP_BLANK("   ")
    ;

    private final String identifier;

    BridgeConst(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
