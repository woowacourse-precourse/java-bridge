package bridge.type;

import java.util.Arrays;

public enum SlabType {
    DOWN(0, "D"),
    UP(1, "U"),
    UNKNOWN(-1, "N");

    private final int id;
    private final String typeName;

    public static SlabType create(int id) {
        return Arrays.stream(SlabType.values())
                .filter(type -> type.id == purifyId(id))
                .findFirst()
                .orElse(SlabType.UNKNOWN);
    }

    private static int purifyId(int id) {
        boolean hasId = Arrays.stream(SlabType.values())
                .anyMatch(slabType -> slabType.id == id);

        if (!hasId) {
            return -1;
        }

        return id;
    }

    SlabType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
