package bridge.domain.bridge.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeMapComponent {
    UP(1, "U"),
    DOWN(0, "D");

    private final int code;
    private final String signature;

    BridgeMapComponent(int code, String signature) {
        this.code = code;
        this.signature = signature;
    }

    public static BridgeMapComponent fromCode(int code) {
        return Arrays.stream(BridgeMapComponent.values())
                .filter(component -> component.code == code)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public String getSignature() {
        return signature;
    }
}
