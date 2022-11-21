package bridge.validation;

public class GameCommandValidation {
    private final String ERROR_MESSAGE = "[ERROR] ";
    private final String NOT_R_OR_Q_ERROR_MESSAGE = "R 또는 Q만 입력해주세요!";

    public void validate(String gameCommand) {
        validateROrQ(gameCommand);
    }

    public void validateROrQ(String gameCommand) {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_R_OR_Q_ERROR_MESSAGE);
        }
    }
}
