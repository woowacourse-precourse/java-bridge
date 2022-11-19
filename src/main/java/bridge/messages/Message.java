package bridge.messages;

public enum Message {
    LEFT_BAR ("[ "),
    RIGHT_BAR(" ]"),
    CENTER_BAR(" | "),
    MOVE_SUCCESS("O"),
    MOVE_FAIL("X"),
    RESTART("R"),
    QUIT("Q"),
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_SIZE("다리의 길이를 입력해주세요."),
    SELECT_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ASK_RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    UP("U"),
    Down("D"),
    BLANK(" "),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    GAME_FAILURE("게임 성공 여부: 실패"),
    TRY_ATTEMPTS("총 시도한 횟수: ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
