package bridge.type;

import java.util.Optional;
import java.util.stream.Stream;

public enum PositionType{

    UP(1, "U"),
    DOWN(0, "D");

    private final int positionNumber;
    private final String positionSymbol;

    PositionType(int positionNumber, String positionSymbol) {
        this.positionNumber = positionNumber;
        this.positionSymbol = positionSymbol;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public String getPositionSymbol() {
        return positionSymbol;
    }

    public static Optional<String> matchNumber(int number) {
        return Stream.of(values())
                .filter(move -> move.getPositionNumber() == number)
                .map(PositionType::getPositionSymbol)
                .findFirst();
    }

    public static Optional<PositionType> matchSymbol(String readMoveSymbol) {
        return Stream.of(values())
                .filter(position -> position.getPositionSymbol().equals(readMoveSymbol))
                .findFirst();
    }

    public static boolean isPosition(PositionType positionType) {
        return UP.equals(positionType);
    }
}