package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

/*
 * 게임을 진행하는 클래스
 */

public class Game {

    private InputView inputView = new InputView();
    private BridgeGame bridgeGame;

    public void run() {
        initGame();
        playGame();
        endGame();
    }

    private void initGame() {
        int size = 0;
        while (size == 0) {
            OutputView.gameStart();
            size = inputView.readBridgeSize();
            this.bridgeGame = new BridgeGame(size);
        }
    }

    private void playGame() {
        while (true) {
            String move = getMove();
            String result = bridgeGame.move(move);
            if (retryGame(bridgeGame.isGameOver(result)) == false) {
                break;
            }
            if (bridgeGame.isSuccess()) {
                break;
            }
        }
    }

    private void endGame() {
        bridgeGame.getResult();
    }

    private boolean retryGame(boolean isGameOver) {
        if (isGameOver == true) {
            String command = inputView.readGameCommand();
            if (bridgeGame.retry(command)) {
                return true;
            }
            return false;
        }
        return true;
    }

    private String getMove()
    {
        String moving = "";
        while(true)
        {
            moving = inputView.readMoving();
            if(moving != "")
            {
                return moving;
            }
        }
    }

}
