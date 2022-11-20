package bridge.constant;

public enum EventMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.");

    private final String message;

    EventMessage(String message) {
        this.message = message;
    }
}
