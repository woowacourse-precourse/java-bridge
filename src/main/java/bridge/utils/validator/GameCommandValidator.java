package bridge.utils.validator;

import static bridge.utils.Constant.ERROR_MESSAGE;


public class GameCommandValidator {

    private static final String NOT_VALID_COMMAND = "유효한 재시작 여부 입력이 아닙니다.";
    private static final String RESTART = "R";
    private static final String EXIT = "Q";

    private final String gameCommand;

    public GameCommandValidator(String gameCommand) {
        this.gameCommand = gameCommand;
        isValidCommand();
    }

    private void isValidCommand() {
        if (!this.gameCommand.equals(RESTART) && !this.gameCommand.equals(EXIT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_VALID_COMMAND);
        }
    }

}
