package bridge;

import java.util.Arrays;

public enum UpDown {
    U(1),
    D(0);

    private final Integer bridgeNumber;

    UpDown(Integer bridgeNumber){
        this.bridgeNumber = bridgeNumber;
    }

    public static UpDown valueOfLabel(Integer bridgeNumber) {
        UpDown shape = Arrays.stream(values())
                .filter(value -> value.bridgeNumber.equals(bridgeNumber))
                .findAny()
                .orElse(null);
        if (shape == null) {
            return null;
        }
        return shape;
    }
}
