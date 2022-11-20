package bridge.structure;

public enum BridgeMoveValue {

    DOWN(0, "D"),
    UP(1, "U"),
    ;

    private final int numberIdentifier;
    private final String stringIdentifier;

    BridgeMoveValue(int numberIdentifier, String stringIdentifier) {
        this.numberIdentifier = numberIdentifier;
        this.stringIdentifier = stringIdentifier;
    }

    public int getNumberIdentifier() {
        return numberIdentifier;
    }

    public String getStringIdentifier() {
        return stringIdentifier;
    }

}
