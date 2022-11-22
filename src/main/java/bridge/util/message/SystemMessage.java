package bridge.util.message;

public enum SystemMessage {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MOVING_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART_OR_QUICK("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    DONE("최종 게임 결과"),
    PLAY_COUNT("총 시도한 횟수: %d%n"),
    OCCUR_EXCEPTION("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    TOO_MUCH_RTY("너무 많은 시도를 하셔서 게임이 종료됩니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
