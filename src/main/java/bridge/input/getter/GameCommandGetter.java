package bridge.input.getter;

import bridge.console.InputView;
import bridge.input.validator.GameCommandValidator;

public class GameCommandGetter {
    private static final String TEXT_PROMPT_FOR_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String INVALID_GAME_COMMAND = "재시도(\"R\") 또는 종료(\"Q\")만 가능합니다.";

    private static GameCommandGetter instance;

    private final InputView inputView;
    private final GameCommandValidator validator;

    private GameCommandGetter() {
        this.inputView = InputView.getInputView();
        this.validator = new GameCommandValidator();
    }

    public static GameCommandGetter getGameCommandGetter() {
        if (instance == null) {
            instance = new GameCommandGetter();
        }
        return instance;
    }

    public String getGameCommandFromConsole() throws IllegalArgumentException {
        printPromptForGameCommand();
        String userInput = inputView.readGameCommand();

        if (validator.isValidGameCommand(userInput)) {
            return userInput;
        }

        throw new IllegalArgumentException(INVALID_GAME_COMMAND);
    }

    private void printPromptForGameCommand() {
        System.out.println(TEXT_PROMPT_FOR_GAME_COMMAND);
    }
}
