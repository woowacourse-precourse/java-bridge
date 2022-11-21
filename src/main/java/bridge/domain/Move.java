package bridge.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Move {

    CORRECT("O", (string, direction) -> string.equals(direction.getDirectionInitial())),
    WRONG("X", (string, direction) -> string.equals(direction.getDirectionInitial())),
    EMPTY(" ", (string, direction) -> !string.equals(direction.getDirectionInitial()));

    private final String status;
    private final BiPredicate<String, Direction> isMatch;

    Move(String status, BiPredicate<String, Direction> isMatch) {
        this.status = status;
        this.isMatch = isMatch;
    }

    public static String getFilterMove(String string, Direction filterDirection) {
        return Arrays.stream(Move.values())
                .filter(move -> move.isMatch.test(string, filterDirection))
                .findAny()
                .orElse(EMPTY)
                .getStatus();
    }

    private String getStatus() {
        return status;
    }
}
