package bridge.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public enum Move {

    CORRECT("O"
            , (string, bridgeDirection) -> string.equals(bridgeDirection.getDirectionInitial())
            , (string, direction) -> string.equals(direction.getDirectionInitial())),
    WRONG("X"
            , (string, bridgeDirection) -> true
            , (string, direction) -> !string.equals(direction.getDirectionInitial())),
    EMPTY(" "
            , (string, bridgeDirection) -> !string.equals(bridgeDirection.getDirectionInitial())
            , (string, direction) -> string.equals(direction.getDirectionInitial()));

    private final String status;
    private final BiPredicate<String, Direction> isMatchBridge;
    private final BiPredicate<String, Direction> isMatchDirection;

    Move(String status, BiPredicate<String, Direction> isMatchBridge, BiPredicate<String, Direction> isMatchDirection) {
        this.status = status;
        this.isMatchBridge = isMatchBridge;
        this.isMatchDirection = isMatchDirection;
    }

    public static String getFilterBridgeMove(String string, Direction bridgeDirection, Direction canDirection) {
        Stream<Move> moveStream = Arrays.stream(Move.values())
                .filter(move -> move.isMatchBridge.test(string, bridgeDirection));

        return getFilterDirectionMove(moveStream, string, canDirection);
    }

    private static String getFilterDirectionMove(Stream<Move> moves, String string, Direction canDirection) {
        return moves.filter(move -> move.isMatchDirection.test(string, canDirection))
                .findAny()
                .orElse(EMPTY)
                .getStatus();
    }

    private String getStatus() {
        return status;
    }
}
