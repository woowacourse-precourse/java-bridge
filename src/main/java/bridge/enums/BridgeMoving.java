package bridge.enums;

import java.util.Arrays;

/**
 * 이동할 때 사용되는 enum
 */
public enum BridgeMoving {
    D(0),
    U(1);

    private final int numberNotation;

    BridgeMoving(int numberNotation) {
        this.numberNotation = numberNotation;
    }

    public int getNumberNotation() {
        return numberNotation;
    }

    public static String getName(int number) {
        return Arrays.stream(BridgeMoving.values())
                .filter(cell -> cell.getNumberNotation() == number)
                .findAny()
                .get().name();
    }
}
