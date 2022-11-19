package bridge.domain.constant;

public enum ResultMessage {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String resultMessage;

    ResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public String toString() {
        return this.getResultMessage();
    }
}
