package bridge;

public enum Message {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ERROR_NOT_NUMBER("[ERROR] 숫자를 입력해주세요. "),
    ERROR_BRIDGE_SIZE_RANGE("[ERROR] 다리 길이는 3부터 20까지의 숫자만 입력가능합니다. "),
    MOVING_CHOOSE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ERROR_MOVE("[ERROR] U 혹은 D만 입력가능합니다. ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
