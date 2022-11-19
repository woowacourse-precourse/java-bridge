package bridge.view;

public enum OutputMessage {
    BRIDGE_IS_NUMBER("다리 길이는 숫자여야 합니다."),
    BRIDGE_HAS_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_IS_U_OR_D("이동할 칸은 U나 D여야 합니다."),
    GAME_START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    INPUT_NUMBER_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVING_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private static final String errorMessagePrefix = "[ERROR] ";
    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getErrorMessage() {
        return errorMessagePrefix + outputMessage;
    }

    public String getInputMessage() {
        return outputMessage;
    }
}
