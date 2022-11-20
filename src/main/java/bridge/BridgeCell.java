package bridge;

import java.util.Arrays;

public enum BridgeCell {
    D(0),
    U(1),
    UNDEFINED(-1);

    private final int numberNotation;

    BridgeCell(int numberNotation) {
        this.numberNotation = numberNotation;
    }

    public int getNumberNotation() {
        return numberNotation;
    }

    public static String toString(int number) {
        return Arrays.stream(BridgeCell.values())
                .filter(cell -> cell.getNumberNotation() == number)
                .findAny()
                .orElse(UNDEFINED)
                .toString();
    }
}
