package bridge.view;

public enum InputMessage {

    GAME_START("다리 건너기 게임을 시작합니다"),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String inputMsg;

    InputMessage(String inputMsg) {
        this.inputMsg = inputMsg;
    }

    public String getInputMsg() {
        return inputMsg;
    }
}
