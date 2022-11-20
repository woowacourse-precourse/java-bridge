package model.enums;

import java.util.Arrays;

public enum GameStatus {
    IN_PROCESS(false, false), OVER(false, true), CLEARED(true, false);

    private final boolean succeed;
    private final boolean fail;

    GameStatus(boolean succeed, boolean fail) {
        this.succeed = succeed;
        this.fail = fail;
    }

    public boolean in_process() {
        return !succeed && !fail;
    }

    public boolean succeed() {
        return this.succeed;
    }

    public boolean fail() {
        return this.fail;
    }

    public static GameStatus getMatchStatus(boolean succeed, boolean fail) {
        return Arrays.stream(GameStatus.values()).filter((status) -> status.succeed == succeed && status.fail == fail)
                .findFirst().get();
    }
}
