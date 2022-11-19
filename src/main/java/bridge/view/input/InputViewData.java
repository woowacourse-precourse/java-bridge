package bridge.view.input;

import bridge.constant.Constants;

public enum InputViewData {

    BRIDGE_LENGTH("\n다리의 길이를 입력해주세요.",
            input -> Constants.MIN_LENGTH <= Integer.parseInt(input) && Integer.parseInt(input) <= Constants.MAX_LENGTH,
            String.format("[Error] %s 이상 %s 이하의 숫자만 입력할 수 있습니다.", Constants.MIN_LENGTH, Constants.MAX_LENGTH)),
    MOVING_ROUTE(String.format("\n이동할 칸을 선택해주세요. (위: %s, 아래: %s)", Constants.UP, Constants.DOWN),
            input -> input.equals(Constants.UP) || input.equals(Constants.DOWN),
            "[ERROR] 해당하는 문자만 입력할 수 있습니다."),
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
