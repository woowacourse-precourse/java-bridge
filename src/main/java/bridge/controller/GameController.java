package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private int count = 0;
    private List<String> bridge;
    private boolean tf = true;
    private boolean re;

    public void gameTotalProgress() {
        countUp();
        repeatProgress();
        if (!tf) {
            if (re) {
                outputView.setBridge("[]");
                gameTotalProgress();
                return;
            }
        }
        gameResult();
    }

    private void repeatProgress() {
        for (int idx = 0; idx < bridge.size(); idx++) {
            gameProgress(idx);
            if (!tf) {
                outputView.retry();
                re = reStart();
                break;
            }
        }
    }

    private void countUp() {
        if (count == 0)
            gameStart();
        count++;
    }

    private void gameStart() {
        outputView.start();
        outputView.setBridge("[]");
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private void gameProgress(int idx) {
        outputView.choice();
        String move = inputView.readMoving();
        tf = bridgeGame.move(move, bridge, idx);
        outputView.printMap(move, tf, idx);
        outputView.printMove();
    }

    private boolean reStart() {
        re = bridgeGame.retry(inputView.readGameCommand());
        return re;
    }

    private void gameResult() {
        if (!tf) {
            outputView.printFail(count);
            return;
        }
        outputView.printSuccess(count);
    }

}
