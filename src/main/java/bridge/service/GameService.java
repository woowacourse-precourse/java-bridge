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

    public String pauseGame() {
        while (true) {
            try {
                OutputView.messageRetryInput();
                return InputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void increaseCount() {
        game.increaseTryCount();
    }
}
