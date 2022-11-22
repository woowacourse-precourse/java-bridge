package bridge;

public enum ResultType {
    SUCCESS("O"), FAIL("X"), EMPTY(" ");

    private final String value;

    ResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * ResultType을 한글 문자열로 변환한다.
     * 
     * @return 한글 문자열 | "성공" 혹은 "실패"
     */
    public String toKoreanString() {
        if (this == SUCCESS) {
            return "성공";
        }
        if (this == FAIL) {
            return "실패";
        }
        return "";
    }
}
