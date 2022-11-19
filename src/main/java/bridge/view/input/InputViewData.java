package bridge.view.input;

public enum InputViewData {

    ;

    private String requestMessage;
    private InputFormCheck inputFormCheck;
    private String errorMessage;

    InputViewData(String requestMessage, InputFormCheck inputFormCheck, String errorMessage) {
        this.requestMessage = requestMessage;
        this.inputFormCheck = inputFormCheck;
        this.errorMessage = errorMessage;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isCorrect(String input) {
        try {
            return inputFormCheck.isCorrect(input);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
