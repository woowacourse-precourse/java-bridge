package bridge.domain;

public class ChallengeNumbers {

    private final int value;

    public ChallengeNumbers(final int value) {
        this.value = value;
    }

    ChallengeNumbers increase() {
        return new ChallengeNumbers(value + 1);
    }

    int value() {
        return value;
    }
}
