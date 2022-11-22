package bridge.domain;

import bridge.constants.ErrorCode;
import java.util.Arrays;

public enum Bridge {
    UP_BRIDGE("U", 1),
    DOWN_BRIDGE("D", 0);

    private final String symbol;
    private final int mappingNumber;

    Bridge(String symbol, int mappingNumber) {
        this.symbol = symbol;
        this.mappingNumber = mappingNumber;
    }

    public static String getBridgeSymbolBy(int number) {
        return Arrays.stream(Bridge.values())
                .filter(bridge -> bridge.getMappingNumber() == number)
                .findFirst()
                .orElseThrow(ErrorCode.ERROR_NO_BRIDGE_MATCHING_NUMBER::throwIllegalArgumentException)
                .getSymbol();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getMappingNumber() {
        return mappingNumber;
    }

}
