package bridge.constant.message;

public enum OutputMessage {
    START_OF_GAME("다리 건너기 게임을 시작합니다."),

    RESULT_OF_GAME("최종 게임 결과"),
    SUCCESS_OR_FAILURE("게임 성공 여부: "),
    TOTAL_ATTEMPTS("총 시도한 횟수: "),

    SUCCESS("성공"),
    FAILURE("실패");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
