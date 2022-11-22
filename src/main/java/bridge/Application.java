package bridge;

import bridge.presentation.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            GamePlay gamePlay = new GamePlay();
            gamePlay.initGame();
            gamePlay.gameStart();
        } catch (IllegalArgumentException e) {
            OutputView outputView = new OutputView();
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
