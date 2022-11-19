package model;

import static constant.Config.ERROR;
import static model.CommandType.QUIT;
import static model.CommandType.RETRY;

public class GameCommand {
    private static final String VALUE_ERROR = ERROR + String.format("재시도/종료 여부는 %s 또는 %s여야 합니다.", RETRY.getMark(), QUIT.getMark());
    private final String command;

    public GameCommand(String command) {
        String upperCaseCommand = command.toUpperCase().trim();
        validateValue(upperCaseCommand);
        this.command = upperCaseCommand;
    }

    private void validateValue(String gameCommand) {
        if (!RETRY.isEqualsMark(gameCommand) && !QUIT.isEqualsMark(gameCommand)) {
            throw new IllegalArgumentException(VALUE_ERROR);
        }
    }

    public boolean isRestart() {
        return CommandType.isRetry(command);
    }
}
