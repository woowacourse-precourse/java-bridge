package bridge.constant;

public enum OutputMessage {

    GAME_FINAL_RESULT("최종 게임 결과"),
    FINAL_SUCCESS_STATUS("게임 성공 여부: "),
    NUMBER_OF_GAME_TRY("총 시도한 횟수: "),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String convertToFinalStatus(boolean status) {
        if (status) {
            return GAME_SUCCESS.message;
        }
        return GAME_FAIL.message;
    }
}
