package bridge.util;

public enum Errors {
    ERROR_BRIDGE_LENGTH("[ERROR] 다리 길이가 범위(3~20)을 벗어났습니다.");

    private String message;

    Errors(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
