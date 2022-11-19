package bridge;

import java.util.Optional;
import java.util.stream.Stream;

public enum Position {

    UP(1, "U"),
    DOWN(0, "D");

    private final int moveNumber;
    private final String moveSymbol;

    Position(int positionNumber, String positionSymbol) {
        this.moveNumber = positionNumber;
        this.moveSymbol = positionSymbol;
    }

    public String getMoveSymbol() {
        return moveSymbol;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public static Optional<String> matchNumber(int number) {
        return Stream.of(values()).filter(move -> move.getMoveNumber() == number)
                .map(Position::getMoveSymbol)
                .findFirst();
    }
}