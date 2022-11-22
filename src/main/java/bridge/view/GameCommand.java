package bridge.view;

import bridge.constant.ErrorMessage;
import java.util.Arrays;

public enum GameCommand {
    RESTART("R", true), QUIT("Q", false);

    private final String gameCommand;
    private final boolean willRestart;

    GameCommand(String gameCommand, boolean willRestart) {
        this.gameCommand = gameCommand;
        this.willRestart = willRestart;
    }

    public static boolean willRestart(String inputGameCommand) {
        GameCommand gameCommand = Arrays.stream(GameCommand.values())
                .filter(i -> inputGameCommand.equals(i.gameCommand))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(ErrorMessage.restartError.getErrorMessage())
                );
        return gameCommand.willRestart;
    }
}
