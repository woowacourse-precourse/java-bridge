package bridge.view.text;

public enum ViewError {
    IS_NOT_INTEGER("다리의 길이는 정수여야 합니다."),
    COMMAND_LENGTH_OUT_OF_RANGE("커맨드는 하나의 대문자 알파벳으로 주어져야 합니다.");

    private final String message;
    ViewError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
