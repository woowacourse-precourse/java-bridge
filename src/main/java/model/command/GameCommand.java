package model.command;

import static constant.Config.ERROR;
import static model.command.CommandType.Q;
import static model.command.CommandType.R;

public class GameCommand {
    private static final String VALUE_ERROR = ERROR + String.format("재시도/종료 여부는 %s 또는 %s여야 합니다.", R, Q);
    private final String command;

    public GameCommand(String command) {
        String upperCaseCommand = command.toUpperCase().trim();
        validateValue(upperCaseCommand);
        this.command = upperCaseCommand;
    }

    private void validateValue(String gameCommand) {
        if (!R.isEqualsMark(gameCommand) && !Q.isEqualsMark(gameCommand)) {
            throw new IllegalArgumentException(VALUE_ERROR);
        }
    }

    public boolean isRetry() {
        return CommandType.isRetry(command);
    }
}
