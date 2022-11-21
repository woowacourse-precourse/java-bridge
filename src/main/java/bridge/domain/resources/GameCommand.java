package bridge.domain.resources;

import bridge.domain.exception.InvalidGameCommandException;

public class GameCommand {

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    private final String gameCommand;

    private GameCommand(final String gameCommand) {
        if (!isRetryOrQuit(gameCommand)) {
            throw new InvalidGameCommandException();
        }
        this.gameCommand = gameCommand;
    }

    private boolean isRetryOrQuit(String gameCommand) {
        return gameCommand.equals(RETRY) || gameCommand.equals(QUIT);
    }

    public static GameCommand from(final String gameCommand) {  // 정적 팩토리 메소드
        return new GameCommand(gameCommand);
    }

    public String getGameCommand() {
        return gameCommand;
    }

}
