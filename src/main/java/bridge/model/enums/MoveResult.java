package bridge.model.enums;

import java.util.Arrays;

public enum MoveResult {
    SUCCESS( true), FAIL( false);

    private final Boolean succeed;

    MoveResult(Boolean succeed) {
        this.succeed = succeed;
    }

    public boolean succeed() {
        return succeed;
    }

    public static MoveResult getMatchResult(Boolean succeed) {
        return Arrays.stream(MoveResult.values()).filter((moveResult) -> moveResult.succeed == succeed)
                .findFirst().get();
    }
}
