package bridge.validator;

import bridge.view.OutputView;

public class GameCommandValidator {
    private static final String RETRY_ERROR_MESSAGE = "[ERROR] 재시도는 R, 종료는 Q로 가능합니다.";

    private static final String QUIT = "Q";
    private static final String RETRY = "R";

    public static void validate(String input) {
        if (!input.equals(QUIT) && !input.equals(RETRY)) {
            OutputView.printErrorMessage(RETRY_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
