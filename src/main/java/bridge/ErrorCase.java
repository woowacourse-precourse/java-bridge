package bridge;

public enum ErrorCase {
    SIZE_ERROR("[ERROR] 다리 길이는 3 ~ 20 사이의 숫자여야 합니다."),
    MOVE_ERROR("[ERROR] U, D 커멘드만 입력해주세요."),
    RESTART_ERROR("[ERROR] R, Q 커멘드만 입력해주세요.");

    ErrorCase(String error){
        this.error = error;
    }
    private final String error;

    public String getError() {
        return error;
    }
}
