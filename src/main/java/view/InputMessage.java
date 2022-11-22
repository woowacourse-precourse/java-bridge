package view;

public enum InputMessage {
    SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    MOVING_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String inputMessage;
    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
