package bridge.input.getter;

import bridge.console.InputView;
import bridge.input.validator.MoveValidator;

public class MoveGetter {
    private static final String TEXT_PROMPT_FOR_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ERROR_INVALID_MOVE = "이동은 위칸(\"U\") 또는 아래칸(\"D\")으로만 가능합니다.";

    private static MoveGetter instance;

    private final InputView inputView;
    private final MoveValidator validator;

    private MoveGetter() {
        this.inputView = InputView.getInputView();
        this.validator = new MoveValidator();
    }

    public static MoveGetter getMoveGetter() {
        if (instance == null) {
            instance = new MoveGetter();
        }
        return instance;
    }

    public String getMoveFromConsole() throws IllegalArgumentException {
        printPromptForMove();
        String userInput = inputView.readMove();

        if (validator.isValidMove(userInput)) {
            return userInput;
        }
        throw new IllegalArgumentException(ERROR_INVALID_MOVE);
    }

    private void printPromptForMove() {
        System.out.println(TEXT_PROMPT_FOR_MOVE);
    }
}
