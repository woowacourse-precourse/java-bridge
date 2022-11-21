package bridge.constant;

public enum Message {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    ENTER_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    ENTER_MOVE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ENTER_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_RESULT("최종 게임 결과"),
    GAME_SUCCESS_OR_NOT("게임 성공 여부: {0}"),
    TOTAL_COUNT_OF_TRY("총 시도한 횟수: {1}");
    private final String message;
    private final String newLine = "\n";

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message + newLine;
    }
}
