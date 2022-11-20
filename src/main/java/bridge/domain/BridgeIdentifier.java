package bridge.domain;

import java.util.Arrays;

public enum BridgeIdentifier {

    UP("U", 1),
    DOWN("D", 0);

    private final String valueOfString;
    private final int valueOfInt;

    BridgeIdentifier(String valueOfString, int valueOfInt) {
        this.valueOfString = valueOfString;
        this.valueOfInt = valueOfInt;
    }

    public static String convertIntToString(int valueOfInt) {
        return Arrays.stream(values())
                .filter(identifier -> identifier.valueOfInt == valueOfInt)
                .findFirst()
                .get().valueOfString;
    }
}
