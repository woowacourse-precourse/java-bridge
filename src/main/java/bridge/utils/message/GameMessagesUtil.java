package bridge.utils.message;

public enum GameMessagesUtil {
    START("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    CHOICE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    SHOW_BRIDGE("[ %s ]\n[ %s ]\n"),
    INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    SUCCESS_OR_NOT("게임 성공 여부: %s"),
    TOTAL_TRY("총 시도한 횟수: %d"),
    DELIMITER(" | ");

    final String message;

    GameMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
