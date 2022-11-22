package bridge.view;

public enum ErrorMessage {
    ERROR_MESSAGE_SIZE_OUT_OF_RANGE("[ERROR] 3과 20사이의 숫자를 입력하세요."),
    ERROR_MESSAGE_INPUT_MOVING_NOT_VALID("[ERROR] 문자 U 또는 D를 입력하세요."),
    ERROR_MESSAGE_INPUT_RETRY_CHOICE_NOT_VALID("[ERROR] 문자 R 또는 Q를 입력하세요");

    private final String errorMessage;
    ErrorMessage(String message){
        this.errorMessage = message;
    }

    public String getMessage() {
        return errorMessage;
    }
}
