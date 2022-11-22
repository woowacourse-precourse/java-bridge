package bridge.view;

public enum Message {
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_INPUT_REQUEST_MESSAGE("다리의 길이를 입력해주세요."),
    MOVING_SPACE_INPUT_REQUEST_MESSAGE("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"),
    SPACE_DELIMITER("|"),
    ENTRANCE_OF_BRIDGE("["),
    EXIT_OF_BRIDGE("]"),
    GAME_COMMAND_INPUT_REQUEST_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)"),
    FINAL_GAME_RESULT_MESSAGE("최종 게임 결과"),
    SUCCESS("성공"),
    FAIL("실패"),
    GAME_SUCCESS_OR_NOT_MESSAGE("게임 성공 여부: "),
    TOTAL_TRY_COUNT_MESSAGE("총 시도한 횟수: ");



    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getSuccessResultMessage(boolean isFailed) {
        if (isFailed) {
            return FAIL.getMessage();
        }
        return SUCCESS.getMessage();
    }
}
