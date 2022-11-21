package bridge.domain.bridge_game;

public class NumberOfChallenges {

    private final int value;

    public NumberOfChallenges(int value) {
        this.value = value;
    }

    NumberOfChallenges increase() {
        return new NumberOfChallenges(value + 1);
    }

    int value() {
        return value;
    }
}
