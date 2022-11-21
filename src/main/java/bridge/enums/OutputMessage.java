package bridge.enums;

public enum OutputMessage {
    SUCCESS(" O ", "성공"),
    FAILURE(" X ", "실패"),
    NOTHING("   ", ""),
    DELIMITER("|", ""),
    NO_DELIMITER("", ""),
    GAME_START_MESSAGE("", "다리 건너기 게임을 시작합니다."),
    GAME_RESULT_MESSAGE("", "최종 게임 결과"),
    GAME_SUCCESS_OR_FAILURE("", "게임 성공 여부: "),
    TOTAL_ATTEMPTS("", "총 시도한 횟수: ");


    private String value;
    private String message;

    OutputMessage(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
