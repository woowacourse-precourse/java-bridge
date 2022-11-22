package bridge;

import static bridge.OutputView.*;
import static bridge.InputView.*;

public class BridgeGameController {

    private final BridgeGame bridgeGame;

    public BridgeGameController(BridgeGame bridgeGame) { this.bridgeGame = bridgeGame; }

    public void setBridge() {
        bridgeGame.setBridge(readBridgeSize());
    }

    public void run() {
        try {
            startGame();
            playGame();
            endGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startGame() {
        printStartGameMsg();
        setBridge();
    }
    public void playGame() {
        if (bridgeGame.checkPlay(InputView.readMoving()))
            playGame();
        if (bridgeGame.checkSucess())
            return;
        if (bridgeGame.checkRetry(InputView.readGameCommand()))
            retryGame();
    }
    public void retryGame() {
        bridgeGame.retry();
        playGame();
    }
    public void endGame() {
        bridgeGame.printResult();
    }
}
