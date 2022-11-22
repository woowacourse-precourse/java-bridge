package bridge.domain.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final int numberBridgeState;
    private final String wordBridgeState;

    BridgeDirection(int numberBridgeState, String wordBridgeState) {
        this.numberBridgeState = numberBridgeState;
        this.wordBridgeState = wordBridgeState;
    }

    private static boolean isSameBridgeState(BridgeDirection bridgeDirection, int numberBridgeState) {
        return bridgeDirection.numberBridgeState == numberBridgeState;
    }

    private static boolean isSameBridgeState(BridgeDirection bridgeDirection, String wordBridgeState) {
        return bridgeDirection.wordBridgeState.equals(wordBridgeState);
    }

    public static BridgeDirection findByNumberBridgeDirection(int numberBridgeState) {
        return Arrays.stream(BridgeDirection.values())
                .filter(bridgeDirection -> isSameBridgeState(bridgeDirection, numberBridgeState))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static BridgeDirection findByWordBridgeDirection(String wordBridgeState) {
        return Arrays.stream(BridgeDirection.values())
                .filter(bridgeDirection -> isSameBridgeState(bridgeDirection, wordBridgeState))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static String transformToWordDirection(int numberBridgeState) {
        BridgeDirection bridgeDirection = findByNumberBridgeDirection(numberBridgeState);
        if (Objects.isNull(bridgeDirection)) {
            throw new NullPointerException();
        }
        return bridgeDirection.wordBridgeState;
    }

}
