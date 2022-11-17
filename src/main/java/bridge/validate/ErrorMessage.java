package bridge.validate;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    INPUT_NOT_A_NUMBER("입력값이 숫자가 아닙니다."),
    NUMBER_OUT_OF_RANGE("올바르지 않은 범위의 숫자입니다."),
    PROPER_BRIDGE_LENGTH("( 다리 길이는 3이상 20이하 )"),
    NOT_PROPER_MOVE("'U', 'D' 중에 입력해주세요.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
