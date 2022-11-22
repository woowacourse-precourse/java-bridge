package bridge.util;

public enum BridgeGameMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"
            + "\n%s"
            + "\n게임 성공 여부: %s"
            + "\n총 시도한 횟수: %d");

    private final String message;

    BridgeGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
