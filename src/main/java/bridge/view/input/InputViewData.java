package bridge.view.input;

import bridge.constant.Constants;
import java.util.function.Predicate;

public enum InputViewData {

    BRIDGE_LENGTH("\n다리의 길이를 입력해주세요.",
            input -> Constants.MIN_LENGTH <= Integer.parseInt(input) && Integer.parseInt(input) <= Constants.MAX_LENGTH,
            String.format("[ERROR] %s 이상 %s 이하의 숫자만 입력할 수 있습니다.", Constants.MIN_LENGTH, Constants.MAX_LENGTH)),
    MOVING_ROUTE(String.format("\n이동할 칸을 선택해주세요. (위: %s, 아래: %s)", Constants.UP, Constants.DOWN),
            input -> input.equals(Constants.UP) || input.equals(Constants.DOWN),
            "[ERROR] 해당하는 문자만 입력할 수 있습니다."),
    RETRY(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", Constants.RETRY, Constants.QUIT),
            input -> input.equals(Constants.RETRY) || input.equals(Constants.QUIT),
            "[ERROR] 해당하는 문자만 입력할 수 있습니다.");

    private String requestMessage;
    private Predicate<String> formCheck;
    private String errorMessage;

    InputViewData(String requestMessage, Predicate<String> formCheck, String errorMessage) {
        this.requestMessage = requestMessage;
        this.formCheck = formCheck;
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
            return formCheck.test(input);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
