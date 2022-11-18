package bridge.config;

import java.util.Arrays;

public enum BridgeComponent {
    D(0, "D"),
    U(1, "U");

    private final int generateNumber;
    private final String component;

    BridgeComponent(int generateNumber, String component) {
        this.generateNumber = generateNumber;
        this.component = component;
    }

    public static BridgeComponent findByNumber(int requestNumber) {
        return Arrays.stream(BridgeComponent.values())
                .filter(bridgeComponent -> bridgeComponent.hasNumber(requestNumber)).findAny().orElseThrow();
    }

    private boolean hasNumber(int generateNumber) {
        return this.generateNumber == generateNumber;
    }

    public String getComponent() {
        return component;
    }

}
