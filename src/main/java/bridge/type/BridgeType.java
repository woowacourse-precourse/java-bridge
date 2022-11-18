package bridge.type;

import java.util.Arrays;

public enum BridgeType {
    DOWN(0, "D"),
    UP(1, "U"),
    UNKNOWN(-1, "N");

    private final int id;
    private final String typeName;

    public static BridgeType create(int id) {
        return Arrays.stream(BridgeType.values())
                .filter(type -> type.id == purifyId(id))
                .findFirst()
                .orElse(BridgeType.UNKNOWN);
    }

    private static int purifyId(int id) {
        boolean hasId = Arrays.stream(BridgeType.values())
                .anyMatch(bridgeType -> bridgeType.id == id);

        if (!hasId) {
            return -1;
        }

        return id;
    }

    BridgeType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
