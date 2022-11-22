package bridge.domain;

public enum ResultFormat {
    SUCCESS("성공", true, 'O'),
    FAIL("실패", false, 'X');

    private final String resultMessage;
    private final Boolean isResult;
    private final Character resultAlphabet;

    private ResultFormat(String resultMessage, boolean isResult, char resultAlphabet) {
        this.resultMessage = resultMessage;
        this.isResult = isResult;
        this.resultAlphabet = resultAlphabet;
    }

    public Boolean getResult() {
        return isResult;
    }

    public Character getResultAlphabet() {
        return resultAlphabet;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public static ResultFormat convertToResultType(boolean isResult) {
        if (SUCCESS.getResult().equals(isResult)) {
            return SUCCESS;
        }
        return FAIL;
    }
}
