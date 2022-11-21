package bridge;

public enum BridgeMakerStatistic {
    UP_PAIR(1, "U"),
    DOWN_PAIR(0, "D"),
    NOT_FOUND(-1, "");

    private final int value;
    private final String letter;

    BridgeMakerStatistic(int value, String letter) {
        this.value = value;
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static BridgeMakerStatistic findPosition(int value) {
        for (BridgeMakerStatistic bridgeMakerStatistic : BridgeMakerStatistic.values()) {
            if (bridgeMakerStatistic.value == value) {
                return bridgeMakerStatistic;
            }
        }
        return NOT_FOUND;
    }
}
