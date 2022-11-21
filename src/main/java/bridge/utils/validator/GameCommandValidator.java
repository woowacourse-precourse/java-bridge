package bridge.utils.validator;

import static bridge.utils.Constant.ERROR_MESSAGE;


public class GameCommandValidator {
    private static final String NOT_VALID_COMMAND = "유효한 재시작 여부 입력이 아닙니다.";
    private final String gameCommand;

    public GameCommandValidator(String gameCommand){
        this.gameCommand = gameCommand;
        isValidCommand();
    }

    private void isValidCommand(){
        if (!this.gameCommand.equals("R") && !this.gameCommand.equals("Q")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_VALID_COMMAND);
        }
    }

}
