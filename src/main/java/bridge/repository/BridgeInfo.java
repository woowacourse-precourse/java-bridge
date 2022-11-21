package bridge.repository;

public enum BridgeInfo {

    DOWN_BRIDGE("D", 0),
    UP_BRIDGE("U", 1);

    private final String letter;
    private final int number;

    BridgeInfo(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    public String getLetter() {
        return this.letter;
    }

    public int getNumber() {
        return this.number;
    }

}
