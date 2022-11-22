package bridge.service;

import bridge.domain.Game;
import bridge.view.OutputView;

public class GameService {
    private Game game;

    public void initializeGame() {
        OutputView.messageGameStart();
        game = new Game(1);
    }
}
