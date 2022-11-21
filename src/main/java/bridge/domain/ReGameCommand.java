package bridge.domain;

import static bridge.domain.ReGameInfo.EXIT;
import static bridge.domain.ReGameInfo.RE_GAME;
import static bridge.utils.Constant.WRONG_INSERT_RE_GAME_MESSAGE;

public class ReGameCommand {

    private final String command;
    public ReGameCommand(String command) {
        validCommand(command);
        this.command = command;
    }

    private void validCommand(String command) {
        if (!command.equals(RE_GAME.getReGameCommand()) &&
                !command.equals(EXIT.getReGameCommand())) {
            throw new IllegalArgumentException(WRONG_INSERT_RE_GAME_MESSAGE);
        }
    }

    public String getCommand() {
        return command;
    }
}
