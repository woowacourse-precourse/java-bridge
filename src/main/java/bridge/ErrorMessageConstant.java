package bridge;

public enum ErrorMessageConstant {
    OCCUR_VOID_OR_SPACE("[ERROR] 빈 공백 혹은 아무것도 입력하지 않았습니다."),
    OCCUR_STRING("[ERROR] 문자가 입력되었습니다."),
    OCCUR_NEGATIVE("[ERROR] 음수가 입력되었습니다."),
    OCCUR_OUT_RANGE("[ERROR] 입력된 수가 범위를 만족하지 못하였습니다."),
    OCCUR_OUT_STRING("[ERROR] 여러 문자를 입력하였습니다."),
    OCCUR_NOT_SPECIFIED_UpOrDown("[ERROR] U 혹은 D만 입력해주세요."),
    OCCUR_NOT_SPECIFIED_RestartOrStop("[ERROR] R 혹은 Q만 입력해주세요."),
    ;
    final private String message;
    ErrorMessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
