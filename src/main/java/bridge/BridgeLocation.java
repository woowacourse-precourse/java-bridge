package bridge;

import java.util.HashMap;
import java.util.Map;

public enum BridgeLocation {
    DOWN("D", 0),
    UP("U", 1);

    private final String signature;
    private final int generateValue;

    private static Map<Integer, String> mapToSignature = new HashMap<>();

    static {
        mapToSignature.put(0, "D");
        mapToSignature.put(1, "U");
    }

    BridgeLocation(String signature, int generateValue) {
        this.signature = signature;
        this.generateValue = generateValue;
    }

    public static String getSignature(int generateValue) {
        return mapToSignature.get(generateValue);
    }
}
