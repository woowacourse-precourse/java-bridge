package bridge;

import java.util.Arrays;

public enum State {

    UP(0, "U"),
    DOWN(1, "D"),
    No_VALUE(-1, "");

    private final int zeroOrOne;
    private final String position;

    State(int zeroOrOne, String position) {
        this.zeroOrOne = zeroOrOne;
        this.position = position;
    }

    public static State of(int randomNumber) {
        return Arrays.stream(State.values())
                .filter(state -> state.zeroOrOne == randomNumber)
                .findAny()
                .orElse(No_VALUE);

    }

    public String getPosition() {
        return this.position;
    }
}
