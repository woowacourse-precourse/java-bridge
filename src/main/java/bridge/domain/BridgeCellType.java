package bridge.domain;

import java.util.Arrays;

public enum BridgeCellType {
    UP("U"),
    DOWN("D"),
    ;
    private final String cellType;

    BridgeCellType(String cellType) {
        this.cellType = cellType;
    }

    public static boolean isNotBridgeCellType(String type) {
        return Arrays.stream(values())
            .noneMatch(value -> value.cellType.equals(type));
    }

    public String getCellType() {
        return cellType;
    }
}
