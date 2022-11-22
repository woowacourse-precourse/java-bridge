package bridge.type;

import bridge.Env;
import java.util.Arrays;

public enum PositionType {
    DOWN(0, Env.CODE_OF_DOWN),
    UP(1, Env.CODE_OF_UP),
    UNKNOWN(-1, Env.CODE_OF_UNKNOWN);

    private final int id;
    private final String typeName;

    PositionType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return this.id;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static PositionType build(int id) {
        return Arrays.stream(PositionType.values())
                .filter(type -> type.id == purifyId(id))
                .findFirst()
                .orElse(PositionType.UNKNOWN);
    }

    public static PositionType build(String typeName) {
        return Arrays.stream(PositionType.values())
                .filter(type -> type.typeName.equals(typeName))
                .findFirst()
                .orElse(PositionType.UNKNOWN);
    }

    private static int purifyId(int id) {
        boolean hasId = Arrays.stream(PositionType.values())
                .anyMatch(slabType -> slabType.id == id);

        if (!hasId) {
            return -1;
        }

        return id;
    }
}
