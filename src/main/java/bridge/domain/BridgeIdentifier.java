package bridge.domain;

import java.util.Arrays;

public enum BridgeIdentifier {

    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int number;

    BridgeIdentifier(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public static String convertNumberToDirection(int number) {
        return Arrays.stream(values())
                .filter(identifier -> identifier.number == number)
                .findFirst()
                .get().direction;
    }
}
