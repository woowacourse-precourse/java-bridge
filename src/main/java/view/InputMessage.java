package view;

public enum InputMessage {
    SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    MOVING_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),

    RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String inputMessage;
    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
