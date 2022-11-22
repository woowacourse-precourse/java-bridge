package bridge.Exception;

public enum ErrorType {
    NOT_THREE_TO_TWENTY("다리의 길이는 3 이상 20 이하의 숫자여야 합니다.");

    final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = "[ERROR] " + errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}
