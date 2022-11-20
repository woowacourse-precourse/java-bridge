package bridge;

import java.util.Arrays;

public enum BridgeChoice {
    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int number;

    BridgeChoice(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public static BridgeChoice fromNumber(int number) {
        return Arrays.stream(BridgeChoice.values())
                .filter(bridgeChoice -> bridgeChoice.number == number)
                .findAny()
                .get();
    }

//    public static BridgeChoice fromSign(String direction) {
//        return Arrays.stream(BridgeChoice.values())
//                .filter(bridgeChoice -> bridgeChoice.direction.equals(direction))
//                .findAny()
//                .get();
//    }

    public String getDirection() {
        return direction;
    }

//    public int getNumber() {
//        return 1 - number;
//    }
}
