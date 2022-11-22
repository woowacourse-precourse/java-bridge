package bridge.constant;

public enum Error {
    ERROR_EMPTY("[ERROR] 아무것도 입력되지 않았습니다. 메시지 조건에 맞게 입력해주세요."),
    ERROR_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_MOVING("[ERROR] 잘못된 입력입니다. U와 D중 하나를 입력해주세요."),
    ERROR_RESTART("[ERROR] 잘못된 입력입니다. R과 Q중 하나를 입력해주세요.");

    private String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
