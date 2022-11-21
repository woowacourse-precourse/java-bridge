package bridge.constant;

public enum Messages {
    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
    MOVING_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    SUCCESS_INFO_MESSAGE("게임 성공 여부: %s"),
    TRY_COUNT_INFO_MESSAGE("총 시도한 횟수: %d"),
    FINISH_RESULT_MESSAGE("최종 게임 결과");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}

