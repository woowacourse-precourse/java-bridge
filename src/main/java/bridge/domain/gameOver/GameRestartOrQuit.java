package bridge.domain.gameOver;

import bridge.view.InputView;

public class GameRestartOrQuit {
    public static String takeGameRestartOrQuitCommand() {
        InputView inputView = new InputView();
        String gameRestartOrQuitCommand = inputView.readGameCommand();

        return gameRestartOrQuitCommand;
    }
}
