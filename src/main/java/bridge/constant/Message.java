package bridge.constant;

public enum Message {
    GREETING("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    GAME_IS_CLEAR("게임 성공 여부: "),
    GAME_COUNT("총 시도한 횟수: "),
    GAME_CLEAR("성공"),
    GAME_FAIL("실패"),
    ERROR_BRIDGE_SIZE_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_BRIDGE_SIZE_FORMAT("다리 길이는 정수형이어야 합니다."),
    ERROR_MOVING_COMMAND("선택은 위(U) 또는 아래(D)여야 합니다."),
    ERROR_GAME_COMMAND("선택은 재시도(R) 또는 종료(Q)여야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Message getClear(boolean result) {
        if(result) {
            return GAME_CLEAR;
        }
        return GAME_FAIL;
    }
}
