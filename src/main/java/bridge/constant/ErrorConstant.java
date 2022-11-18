package bridge.constant;

public enum ErrorConstant {
    INPUT_NUMBER_EXCEPTION("[ERROR] 1부터 20까지의 수가 입력 되어야 합니다."),
    NOT_FOUND_CODE("[ERROR] 해당 코드를 찾을 수 없습니다.");

    String message;
    ErrorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
