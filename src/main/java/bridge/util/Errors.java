package bridge.util;

public enum Errors {
    ERROR_BRIDGE_LENGTH("[ERROR] 다리 길이가 범위(3~20)을 벗어났습니다."),
    ERROR_INPUT_NOT_NUMBER_TYPE("[ERROR] 숫자 타입을 입력해주세요."),
    ERROR_INPUT_UP_OR_DOWN("[ERROR] 'U'나 'D' 이외 문자는 입력할 수 없습니다. ");

    private String message;

    Errors(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
