package bridge.type;

public enum ResultType {
    SUCCESS("성공"), FAIL("실패");

    private final String resultType;

    ResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultType() {
        return resultType;
    }
}
