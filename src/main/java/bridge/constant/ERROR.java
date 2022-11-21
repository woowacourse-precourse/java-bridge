package bridge.constant;

public enum ERROR {
    sizeException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),

    moveException("[ERROR] 움직임을 위한 칸 선택은 U, D 두 가지 키워드만 가능합니다."),
    DEFINITION_EXCEPTION("[ERROR] 선택은 R 또는 Q로 결정시킬 수 있습니다!");


    private String exception;

    ERROR(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
