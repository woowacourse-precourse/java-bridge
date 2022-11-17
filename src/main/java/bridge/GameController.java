package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);
    private int bridgeSize;
    private int count = 0;
    private String move;
    private List<String> bridge;
    private boolean tf = true;
    private boolean re;

    public void gameTotalProgress() {
        if (count == 0)
            gameStart();
        count++;
        for (int idx = 0; idx < bridge.size(); idx++) {
            gameProgress(idx);
            if (!tf) {
                outputView.retry();
                re = reStart();
                break;
            }
        }
        if (!tf) {
            if (re) {
                outputView.setDownBridge("[]");
                outputView.setUpBridge("[]");
                gameTotalProgress();
                return;
            }
        }
        gameResult();
    }

    public void gameStart() {
        outputView.start();
        outputView.setUpBridge("[]");
        outputView.setDownBridge("[]");
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void gameProgress(int idx) {
        outputView.choice();
        move = inputView.readMoving();
        tf = bridgeGame.move(move, bridge, idx);
        outputView.printMap(move, tf, idx);
        outputView.printMove();
    }

    public boolean reStart() {
        re = bridgeGame.retry(inputView.readGameCommand());
        return re;
    }

    public void gameResult() {
        outputView.printResult(tf, count);
    }

}
