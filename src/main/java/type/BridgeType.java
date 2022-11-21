package type;

import java.util.Arrays;

public enum BridgeType {
    LOWER("D", 0),
    UPPER("U", 1),
    EMPTY("없음", Integer.MAX_VALUE);

    private String name;
    private int number;

    BridgeType(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public static String findNameByNumber(int number) {
        return Arrays.stream(BridgeType.values()).filter(bridgeType -> bridgeType.number == number)
                .findAny()
                .orElse(EMPTY)
                .name;

    }
}
