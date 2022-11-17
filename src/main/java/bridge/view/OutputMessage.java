package bridge.view;

public enum OutputMessage {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT_TITLE("최종 게임 결과\n"),
    RESULT_CONTENT("게임 성공 여부: %s\n"),
    NUMBER_OF_ATTEMPT("총 시도한 횟수: %d\n"),
    CORRECT_ANSWER(" O "),
    INCORRECT_ANSWER(" X "),
    BLANK("   "),
    DELIMITER("|"),
    BRIDGE_EDGE("[%s]\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
