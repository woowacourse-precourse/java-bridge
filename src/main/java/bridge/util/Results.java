package bridge.util;

public enum Results {
    SUCCESS_OR_NOT("게임 성공 여부: "),
    NUMBER_OF_ATTEMPTS("총 시도한 횟수: ");

    private final String message;

    Results(String message) {
        this.message = message;
    }

    public String message(final String resultValue) {
        return message + resultValue + "\n";
    }
}
