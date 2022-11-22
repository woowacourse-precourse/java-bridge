package bridge.domain.resources;

import bridge.constant.Constant;
import bridge.domain.exception.InvalidGameCommandException;

public class GameCommand {

    private final String gameCommand;

    private GameCommand(final String gameCommand) {
        if (!isRetryOrQuit(gameCommand)) {
            throw new InvalidGameCommandException();
        }
        this.gameCommand = gameCommand;
    }

    private boolean isRetryOrQuit(final String gameCommand) {
        return gameCommand.equals(Constant.RETRY.getValue()) || gameCommand.equals(Constant.QUIT.getValue());
    }

    public static GameCommand from(final String gameCommand) {  // 정적 팩토리 메소드
        return new GameCommand(gameCommand);
    }

    public String getGameCommand() {
        return gameCommand;
    }

}
