package bridge.validator;

import bridge.constant.ErrorConstant;

public class GameRetryOrEndCommandValidator {

    private static final String RETRY_COMMAND = "R";
    private static final String END_COMMAND = "Q";

    public void validate(String gameRetryOrEndCommand) {
        if (isGameRetryOrEndCommandNotROrNotQ(gameRetryOrEndCommand)) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "게임을 다시 시작할지 여부는 R또는 Q여야합니다.");
        }
    }

    private boolean isGameRetryOrEndCommandNotROrNotQ(String gameRetryOrEndCommand) {
        return !gameRetryOrEndCommand.equals(RETRY_COMMAND) && !gameRetryOrEndCommand.equals(END_COMMAND);
    }
}
