package bridge.constant;

public enum InputMessage {
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_MOVING_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String inputMessage;

    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
