package bridge;

import java.util.List;

public class GameController {
    public InputView inputView = new InputView();
    public OutputView outputView = new OutputView();
    public BridgeGame bridgeGame = new BridgeGame();


    public void gameStart() {
        List<String> bridge = bridgeGame.getBridge();
        List<String> moves = bridgeGame.move();
        boolean hit = bridgeGame.checkAnswer(moves);
        hit = retryGame(hit);
        outputView.printResult(bridge, moves);
        outputView.gameResult(hit);
        outputView.tryNumber(bridgeGame.tryCount);
    }

    private boolean retryGame(boolean hit) {
        if (!hit) {
            List<String> retryMoves = bridgeGame.retry();
            hit = bridgeGame.checkAnswer(retryMoves);
        }
        return hit;
    }
}
