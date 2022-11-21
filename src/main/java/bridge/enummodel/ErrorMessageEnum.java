package bridge.enummodel;

public enum ErrorMessageEnum {
    NOT_VALIDATE("[ERROR] 잘못된 입력값 입니다."),
    NOT_VALIDATE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String value;

    ErrorMessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
