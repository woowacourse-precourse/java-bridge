package bridge.view;

public enum Message {
    MESSAGE_ERROR("[ERROR] "),
    MESSAGE_GAME_START("다리 건너기 게임을 시작합니다."),
    MESSAGE_INPUT_BRIDGE_SIZE(System.lineSeparator() + "다리의 길이를 입력해주세요."),
    MESSAGE_INPUT_BRIDGE_MOVING(System.lineSeparator() + "이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    MESSAGE_RETRY_OR_EXIT(System.lineSeparator() + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    MESSAGE_GAME_RESULT("최종 게임 결과"),
    MESSAGE_GAME_END(System.lineSeparator() + "게임 성공 여부: %s" + System.lineSeparator() + "총 시도한 횟수: %d");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
