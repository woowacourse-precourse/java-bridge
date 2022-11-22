package bridge.util;

public enum ErrorMessage {
    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3 ~ 20 사이의 숫자만 입력해주세요."),
    MOVING_ERROR("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력할 수 있습니다."),
    RETRY_ERROR("[ERROR] 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
