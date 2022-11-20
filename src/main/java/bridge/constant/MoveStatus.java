package bridge.constant;

import java.util.HashMap;
import java.util.Map;

public enum MoveStatus {
    DOWN_SUCCESS(Direction.DOWNSIDE, true, "O"),
    DOWN_FAIL(Direction.DOWNSIDE, false, "X"),
    UP_SUCCESS(Direction.UPSIDE, true, "O"),
    UP_FAIL(Direction.UPSIDE, false, "X");

    private static final String WHITE_SPACE = " ";
    private static final Map<Boolean, Map<Direction, MoveStatus>> storage = new HashMap<>() {
        {
            put(true, new HashMap<>());
            put(false, new HashMap<>());
        }
    };

    static {
        for (MoveStatus moveStatus : MoveStatus.values()) {
            storage.get(moveStatus.didCross).put(moveStatus.direction, moveStatus);
        }
    }

    public static MoveStatus of(boolean didCross, Direction direction) {
        return storage.get(didCross).get(direction);
    }

    private final Direction direction;
    private final boolean didCross;
    private final String mark;

    MoveStatus(Direction direction, boolean didCross, String mark) {
        this.direction = direction;
        this.didCross = didCross;
        this.mark = mark;
    }

    public boolean didCross() {
        return this.didCross;
    }

    public String generateMark(Direction bridgeDirection) {
        if (this.direction.equals(bridgeDirection)) {
            return this.mark;
        }
        return WHITE_SPACE;
    }
}
