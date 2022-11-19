package bridge.constant;

public enum BridgeMove {

    UP("U", 1)
    , DOWN("D", 0)
    ;

    private final String identifier;

    private final Integer number;

    BridgeMove(String letter, Integer number) {
        this.identifier = letter;
        this.number = number;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Integer getNumber() {
        return number;
    }
}
