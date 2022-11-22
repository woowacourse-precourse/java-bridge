package bridge.View;

public enum Message {
    START_GAME_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_COMMAND_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요.(재시도: R, 종료: Q)"),
    RESULT_MESSAGE("최종 게임 결과"),
    SUCCESS_OR_FAILURE_MESSAGE("게임 성공 여부: "),
    SUCCESS_MESSAGE("성공"),
    FAILURE_MESSAGE("실패"),
    TOTAL_ROUND_MESSAGE("총 시도한 횟수: "),
    OPEN_BRACKET("[ "),
    CLOSED_BRACKET(" ]");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    String getMessage() {
        return this.message;
    }
}
