package bridge;

public enum Error {
    INCLUDE_CAHRACTER("숫자만 입력할 수 있습니다."),
    OUT_OF_RANGE("다리 길이는 3 이상 20 이하여야 합니다."),
    U_OR_D("위(U) 또는 아래(D) 중 선택되어야 합니다."),
    R_OR_Q("재시작(R) 또는 종료(Q) 중 선택되어야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + this.message;
    }
}
