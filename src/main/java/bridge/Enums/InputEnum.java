package bridge.Enums;

public enum InputEnum {

    INPUT_SIZE("다리 길이를 입력해 주세요."),
    INPUT_MOVING("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String inputMessage;
    InputEnum(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public void getMessage() {
        System.out.println(inputMessage);
    }
}
