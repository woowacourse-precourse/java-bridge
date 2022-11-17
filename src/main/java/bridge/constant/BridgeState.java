package bridge.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeState {
    UP(1,"U"),
    DOWN(0, "D");

    private final int numberBridgeState;
    private final String bridgeState;

    BridgeState(int numberBridgeState, String bridgeState){
        this.numberBridgeState=numberBridgeState;
        this.bridgeState=bridgeState;
    }

    private static boolean isSameBridgeState(BridgeState bridgeState, int numberBridgeState){
        return bridgeState.numberBridgeState==numberBridgeState;
    }

    private static boolean contains(int numberBridgeState){
        return Arrays.stream(BridgeState.values())
                .anyMatch(bridgeState -> isSameBridgeState(bridgeState, numberBridgeState));
    }

}
