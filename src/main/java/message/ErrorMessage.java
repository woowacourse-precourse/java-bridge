package message;

public enum ErrorMessage {
    TYPE_ERROR("[ERROR] 숫자만 입력 가능합니다."),
    OUT_OF_LENGTH_ERROR("[ERROR] 다리 길이는 3 이상 20 이하의 정수여야 합니다."),
    MOVING_ERROR("[ERROR] 이동할 칸은 U 혹은 D만 입력 가능합니다."),
    RETRY_INPUT_ERROR("[ERROR] 재시도 여부는 R 혹은 Q만 입력 가능합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}