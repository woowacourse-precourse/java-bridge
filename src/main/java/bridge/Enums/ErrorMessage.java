package bridge.Enums;

public enum ErrorMessage {
    PREFIX("[ERROR] "),
    ONLY_NUMBER_ALLOWED("숫자만 입력이 가능합니다."),
    OUT_OF_BRIDGE_ALLOWED_SIZE("다리의 길이는 3~20칸이여야 합니다."),
    ONLY_RQ_INPUT_ALLOWED("재시도 여부 선택은 R(재시도), Q(종료)만 입력이 가능합니다."),
    ONLY_UD_INPUT_ALLOWED("이동할 칸 선택은 U(위) D(아래)만 입력이 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
