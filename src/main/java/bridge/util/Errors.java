package bridge.util;

public enum Errors {
    ERROR_BRIDGE_LENGTH("[ERROR] 다리 길이가 범위(3~20)을 벗어났습니다."),
    ERROR_INPUT_NOT_NUMBER_TYPE("[ERROR] 숫자 타입을 입력해주세요.");

    private String message;

    Errors(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
