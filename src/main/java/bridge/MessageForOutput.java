package bridge;

public enum MessageForOutput {
    MAP_STARTING("["),
    MAP_ENDING("]"),
    FAIL_MARK("X"),
    SEPARATOR("|"),
    SUCCESS_MARK("O"),
    MAP_BLANK(" "),
    GAME_ENDING_HEAD("최종 게임 결과"),
    GAME_SUCCESS_STATUS("게임 성공 여부: "),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패"),
    TRY_COUNT("총 시도한 횟수: ")
    ;

    final String message;
    MessageForOutput(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
