package bridge.Domain;

public enum FinalGameResult {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String resultMessage;

    FinalGameResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public static FinalGameResult resultMessage(long failCount) {
        if (failCount == 0) {
            return SUCCESS;
        }
        return FAILURE;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public boolean successResult() {
        return this == SUCCESS;
    }

    public boolean failResult() {
        return this == FAILURE;
    }
}
