package domain;

public enum OutPutMessage {
    GAME_FAIL("실패"),
    GAME_CLEAR("성공"),
    PARTITION(" | "),
    LEFT_BRIDGE("[ "),
    RIGHT_BRIDGE(" ]"),
    SPLIT_TYPE(","),
    END_MESSAGE("최종 게임 결과"),
    IS_GAME_CLEAR("게임 성공 여부: "),
    TOTAL_GAME_COUNT("총 시도한 횟수: ");

    private final String message;

    OutPutMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
