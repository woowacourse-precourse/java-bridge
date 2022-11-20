package bridge.utils;

import java.util.Arrays;

public enum BridgeConverter {

    U(1,"U"),
    D(0, "D");

    private final int generate;
    private final String direction;

    BridgeConverter(int generate, String direction) {
        this.generate = generate;
        this.direction = direction;
    }

    public static String upOrDown(int generate) {
        return Arrays.stream(BridgeConverter.values())
                .filter(upDown -> upDown.generate == generate)
                .map(upDown -> upDown.direction).findAny()
                .get();
    }
}
