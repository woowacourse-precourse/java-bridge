package bridge.constant;

public enum ErrorConstant {
    INPUT_NUMBER_EXCEPTION("[ERROR] 다리 길이는 1부터 20까지의 수가 입력 되어야 합니다."),
    NOT_FOUND_CODE("[ERROR] 해당 코드를 찾을 수 없습니다."),
    INPUT_DIRECTION_EXCEPTION("[ERROR] 이동 방향은 대문자 U 또는 D가 입력 되어야 합니다.");

    String message;
    ErrorConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
