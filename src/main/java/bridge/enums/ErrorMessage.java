package bridge.enums;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] 유효하지 않은 값을 입력했습니다. 다시 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
