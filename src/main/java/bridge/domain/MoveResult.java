package bridge.domain;

import java.util.Arrays;

public enum MoveResult {
    SAME(true, "O"),
    DIFFERENT(false, "X");

    private final boolean isSame;
    private final String result;

    MoveResult(boolean isSame, String result) {
        this.isSame = isSame;
        this.result = result;
    }

    public static MoveResult makeMoveResult(boolean isSame) {
        MoveResult moveResult = Arrays.stream(values())
                .filter(value -> value.isSame == isSame)
                .findAny()
                .orElse(null);
        return moveResult;
    }
}
