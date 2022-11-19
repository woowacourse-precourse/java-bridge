package bridge.constant;

public enum ErrorMessage {
    NO_NUMERIC_VALUE(" 숫자를 입력해주세요.");
    String errorMessage;
    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
