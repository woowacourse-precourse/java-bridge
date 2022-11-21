package bridge.constant;

public enum EventMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_MOVING_SIZE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    EventMessage(String message) {
        this.message = message;
    }
}
