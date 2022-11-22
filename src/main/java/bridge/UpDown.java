package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum UpDown {
    UP_PASS(1, "U", "PASS", " O ", "   "),
    UP_FAIL(1, "U", "FAIL", " X ", "   "),
    DOWN_PASS(0, "D", "PASS", "   ", " O "),
    DOWN_FAIL(0, "D", "FAIL", "   ", " X ");

    private final Integer bridgeNumber;
    private final String bridgeShape;
    private final String bridgeState;
    private final String bridgeUP;
    private final String bridgeDown;

    static List<String> upBridges = new ArrayList<>();
    static List<String> downBridges = new ArrayList<>();

    UpDown(Integer bridgeNumber, String bridgeShape, String bridgeState, String bridgeUP, String bridgeDown){
        this.bridgeNumber = bridgeNumber;
        this.bridgeShape = bridgeShape;
        this.bridgeState = bridgeState;
        this.bridgeUP = bridgeUP;
        this.bridgeDown = bridgeDown;
    }

    public static String valueOfLabel(Integer bridgeNumber) {
        UpDown shape = Arrays.stream(values())
                .filter(value -> value.bridgeNumber.equals(bridgeNumber))
                .findAny()
                .orElse(null);
        if (shape == null) {
            return null;
        }
        return shape.bridgeShape;
    }

    public static void BridgeGameState(String bridgeShape, String bridgeState) {
        UpDown BridgeGame = Arrays.stream(values())
                .filter(value -> value.bridgeShape.equals(bridgeShape))
                .filter(value -> value.bridgeState.equals(bridgeState))
                .findAny()
                .orElse(null);
        upBridges.add(BridgeGame.bridgeUP);
        downBridges.add(BridgeGame.bridgeDown);
    }

    public static int test(String bridgeShape) {
        UpDown shape = Arrays.stream(values())
                .filter(value -> value.bridgeShape.equals(bridgeShape))
                .findAny()
                .orElse(null);
        if (shape == null) {
            return 0;
        }
        return shape.bridgeNumber;
    }

}
