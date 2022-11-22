package bridge.service;

import bridge.domain.Game;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameService {
    private Game game;

    public void initializeGame() {
        OutputView.messageGameStart();
        game = new Game(1);
    }

    public void pauseGame() {
        while (true) {
            try {
                OutputView.messageRetryInput();
                InputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
