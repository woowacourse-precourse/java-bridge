package bridge.domain.type;

public enum RoundResultType {
    PLAYING("진행중"),
    FAIL("실패"),
    CLEAR("성공");

    final String description;

    RoundResultType(String description) {
        this.description = description;
    }

    public static RoundResultType of(MoveResultType moveResultType, boolean isClear) {
        if (isClear) {
            return CLEAR;
        }
        if (moveResultType.equals(MoveResultType.FAIL)) {
            return FAIL;
        }
        return PLAYING;
    }

    public String getDescription() {
        return this.description;
    }

}
