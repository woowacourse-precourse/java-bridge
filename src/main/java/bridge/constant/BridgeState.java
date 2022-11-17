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
    public static boolean validateBridgeState(int numberBridgeState){
        if(!BridgeState.contains(numberBridgeState)){
            throw new NoSuchElementException();
        }
        return true;
    }
    private static BridgeState findByBridgeNumber(int numberBridgeState){
        return Arrays.stream(BridgeState.values())
                .filter(bridgeState -> isSameBridgeState(bridgeState,numberBridgeState))
                .findAny().orElse(null);
    }

    public static String transform(int numberBridgeState){
        BridgeState bridgeState = findByBridgeNumber(numberBridgeState);
        if(bridgeState==null){
            throw new NullPointerException();
        }
        return bridgeState.bridgeState;
    }

}
