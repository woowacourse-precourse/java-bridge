package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public enum MoveStatus {
    DOWN_SUCCESS(1, true, "D", "O"),
    DOWN_FAIL(1, false, "D", "X"),
    UP_SUCCESS(0, true, "U", "O"),
    UP_FAIL(0, false, "U", "X");

    private static final Map<Boolean, Map<String,MoveStatus>> storage = new HashMap<>(){
        {
            put(true, new HashMap<>());
            put(false,new HashMap<>());
        }
    };

    static {
        for (MoveStatus moveStatus : MoveStatus.values()) {
            storage.get(moveStatus.didCross).put(moveStatus.direction, moveStatus);
        }
    }

    public static MoveStatus of(boolean didCross, String direction) {
        return storage.get(didCross).get(direction);
    }

    private final int index;
    private final boolean didCross;
    private final String direction;
    private final String mark;

    MoveStatus(int index, boolean didCross, String direction, String mark) {
        this.index = index;
        this.didCross = didCross;
        this.direction = direction;
        this.mark = mark;
    }

    public boolean didCross() {
        return this.didCross;
    }
}
