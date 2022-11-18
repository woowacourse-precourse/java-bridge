package bridge.type;

import java.util.Arrays;

public enum BridgeType {
    DOWN(0, "D"),
    UP(1, "U"),
    UNKNOWN(-1, "E");

    private final int id;
    private final String typeName;

    public static BridgeType create(int id) {
        return Arrays.stream(BridgeType.values())
                .filter(type -> type.id == id)
                .findFirst()
                .orElse(BridgeType.UNKNOWN);
    }

    BridgeType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
