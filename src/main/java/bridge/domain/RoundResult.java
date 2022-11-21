package bridge.domain;

public enum RoundResult {
    PLAYING("진행중"),
    FAIL("실패"),
    CLEAR("성공");

    final String description;

    RoundResult(String description) {
        this.description = description;
    }

    public static RoundResult of(MoveResult moveResult, boolean isClear) {
        if (isClear) {
            return CLEAR;
        }
        if (moveResult.equals(MoveResult.FAIL)) {
            return FAIL;
        }
        return PLAYING;
    }

    public String getDescription() {
        return this.description;
    }

}
