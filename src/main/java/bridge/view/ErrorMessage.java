package bridge.view;

public enum ErrorMessage {
    ONLY_NUMBER_POSSIBLE("[ERROR] 다리 길이는 숫자만 입력 가능합니다."),
    OUT_OF_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ONLY_U_OR_D_POSSIBLE("[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력할 수 있습니다."),
    ONLY_R_OR_Q_POSSIBLE("[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력할 수 있습니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
