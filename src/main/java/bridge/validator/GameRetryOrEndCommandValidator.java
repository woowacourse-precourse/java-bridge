package bridge.validator;

import bridge.constant.ErrorConstant;
import bridge.enums.GameCommand;

public class GameRetryOrEndCommandValidator {

    public void validate(String gameRetryOrEndCommand) {
        if (isGameRetryOrEndCommandNotROrNotQ(gameRetryOrEndCommand)) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + "게임을 다시 시작할지 여부는 R또는 Q여야합니다.");
        }
    }

    private boolean isGameRetryOrEndCommandNotROrNotQ(String gameRetryOrEndCommand) {
        return !gameRetryOrEndCommand.equals(GameCommand.RETRY.getCommand())
                && !gameRetryOrEndCommand.equals(GameCommand.END.getCommand());
    }
}
