package bridge.constants;

public enum InputConstants {
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리 길이를 입력해 주세요."),
    CHOOSE_MOVE_COMMAND("이동할 칸을 선택해 주세요. (위: U, 아래: D)"),
    CHOOSE_RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String message;

    private InputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
