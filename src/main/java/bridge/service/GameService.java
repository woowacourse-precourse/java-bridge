package bridge.service;

import bridge.domain.Game;
import bridge.view.OutputView;

public class GameService {
    public Game initializeGame() {
        OutputView.messageGameStart();
        OutputView.messageLengthInput();
        return new Game(1);
    }
}
