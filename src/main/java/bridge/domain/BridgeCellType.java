package bridge.domain;

import java.util.Arrays;

public enum BridgeCellType {

    UP("U"),
    DOWN("D");
    private static final String INVALID_BRIDGE_CELL_TYPE_MESSAGE = "이동할 칸이 올바르지 않습니다. (U or D)";
    private final String cellType;

    BridgeCellType(String cellType) {
        this.cellType = cellType;
    }

    public static BridgeCellType of(String type) {
        return Arrays.stream(values())
            .filter(value -> value.cellType.equals(type))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_BRIDGE_CELL_TYPE_MESSAGE));
    }


    public String getCellType() {
        return cellType;
    }
}
