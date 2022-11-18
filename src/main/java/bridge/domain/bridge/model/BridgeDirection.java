package bridge.domain.bridge.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final int code;
    private final String signature;

    BridgeDirection(int code, String signature) {
        this.code = code;
        this.signature = signature;
    }

    public static BridgeDirection fromCode(int code) {
        return Arrays.stream(BridgeDirection.values())
                .filter(component -> component.code == code)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }


    public static BridgeDirection fromSignature(String signature) {
        return Arrays.stream(BridgeDirection.values())
                .filter(component -> component.signature.equals(signature))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public String getSignature() {
        return signature;
    }
}
