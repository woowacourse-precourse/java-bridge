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
    private String re;

    public void gameTotalProgress() {
        if (count == 0)
            gameStart();
        count++;
        for (int idx = 0; idx < bridge.size(); idx++) {
            gameProgress(idx);
            if (!tf) {
                re = reStart();
                break;
            }
        }
        if (!tf) {
            if (re.equals("R"))
                gameTotalProgress();
        }
        gameResult();
    }

    public void gameStart() {
        outputView.start();
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void gameProgress(int idx) {
        outputView.choice();
        move = inputView.readMoving();
        tf = bridge.get(idx).equals(move);
        outputView.printMap(move, tf, idx);
        outputView.printMove();
    }

    public String reStart() {
        re = inputView.readGameCommand();
        return re;
    }

    public void gameResult() {
        outputView.printResult(tf, count);
    }

}
