package bridge.constant;

public enum Message {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_LENGTH("다리의 길이를 입력해주세요."),
    CHOOSE_STEP("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_MOVING("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    SUC_OR_FAIL("게임 성공 여부:"),
    COUNT_ATTEMPT("총 시도한 횟수: ")
    ;

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
