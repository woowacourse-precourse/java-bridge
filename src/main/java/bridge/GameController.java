package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public InputView inputView = new InputView();
    public OutputView outputView = new OutputView();
    public BridgeGame bridgeGame = new BridgeGame();


    public void gameStart() {

        List<String> bridge = bridgeGame.getBridge();
        List<String> moves = bridgeGame.move();
        boolean hit = bridgeGame.checkAnswer(moves);
        if (!hit) {
            moves = bridgeGame.retry();
            hit = bridgeGame.checkAnswer(moves);
        }
        outputView.printGameEnding(bridge, moves, hit, bridgeGame.tryCount);

    }

}
