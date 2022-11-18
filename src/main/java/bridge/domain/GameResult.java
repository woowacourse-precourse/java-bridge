package bridge.domain;

public enum GameResult {
    SUCCESS(true),
    FAIL(false);

    private final boolean success;

    GameResult(boolean success) {
        this.success = success;
    }

    public static GameResult getGameResult(boolean success) {
        if (success) {
            return GameResult.SUCCESS;
        }

        return GameResult.FAIL;
    }

    @Override
    public String toString() {
        if (success) {
            return "성공";
        }

        return "실패";
    }
}
