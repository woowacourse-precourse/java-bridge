package bridge.domain.bridge;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeDirection {
    UP(1, "U"),
    DOWN(0, "D");

    private final int numberCode;
    private final String signature;

    BridgeDirection(int numberCode, String signature) {
        this.numberCode = numberCode;
        this.signature = signature;
    }

    public static BridgeDirection fromNumberCode(int numberCode) {
        return Arrays.stream(BridgeDirection.values())
                .filter(component -> component.numberCode == numberCode)
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
