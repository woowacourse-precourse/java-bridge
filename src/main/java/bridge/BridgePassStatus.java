package bridge;

/**
 * 통과, 실패, 빈공간 상수 상태 정의
 */
public enum BridgePassStatus {
    PASS("O"),
    BLOCK("X"),
    BLANK(" ");

    private String result;

    BridgePassStatus(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
