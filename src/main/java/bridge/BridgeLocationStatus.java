package bridge;

import java.util.Arrays;
import java.util.List;

public enum BridgeLocationStatus {
    UP("U"),
    DOWN("D");

    private static final String INPUT_BRIDGE_LOCATION_EXCEPTION_MESSAGE = "[ERROR] 이동할 칸은 U(Up), D(Down)의 문자입니다.";

    private final String location;

    BridgeLocationStatus(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public static BridgeLocationStatus getBridgeLocationStatus(String bridgeLocation) {
        return Arrays.stream(values())
                .filter(b -> b.location.equals(bridgeLocation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_BRIDGE_LOCATION_EXCEPTION_MESSAGE));
    }

    public boolean compareBridgeLocation(List<String> randomBridge, BridgeIndex index) {
        return this.location.equals(randomBridge.get(index.getBridgeIndex()));
    }

    public boolean findBridgeLocation(String up){
        return this.location.equals(up);
    }
}
