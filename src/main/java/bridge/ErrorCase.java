package bridge;

public enum ErrorCase {
    ERROR("[ERROR]"),
    SIZE_IS_DIGIT("숫자만 입력해주세요."),
    SIZE_ERROR("다리 길이는 3 ~ 20 사이의 숫자여야 합니다."),
    MOVE_ERROR("U, D 커멘드만 입력해주세요."),
    RESTART_ERROR("R, Q 커멘드만 입력해주세요.");

    ErrorCase(String error){
        this.error = error;
    }
    private final String error;

    public String getError() {
        return error;
    }
}
