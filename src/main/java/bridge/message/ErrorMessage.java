package bridge.message;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    INPUT_NOT_A_NUMBER("숫자가 아닙니다. 다시 입력해 주세요."),
    NUMBER_OUT_OF_RANGE("올바른 범위의 길이를 다시 입력해 주세요. "),
    PROPER_BRIDGE_LENGTH("( 최소 길이 = 3 , 최대 길이 = 20 )"),
    NOT_PROPER_MOVE("'U' 혹은 'D'로 다시 입력해주세요."),
    NOT_PROPER_GAME_COMMAND("'R' 혹은 'Q'로 다시 입력해주세요.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
