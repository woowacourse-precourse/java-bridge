package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.model.Retry.isRetry;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private final int WIDTH = 2;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public boolean gamePlay() {
        OutputView.printStart();

        bridgeGame.setBridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));

        while (!bridgeGame.isEnd()) {
            while (true) {
                bridgeGame.move(InputView.readMoving());

                OutputView.printMap(bridgeGame.getInput(), WIDTH);

                if (bridgeGame.isAnswer()) {
                    break;
                }
                if (!isRetry(InputView.readGameCommand())) {
                    return false;
                }
                bridgeGame.retry();
            }
        }
        gameFinalBridgeState();
        return bridgeGame.isAnswer();
    }

    public void gameFinalBridgeState(){
        OutputView.printFinal();
        OutputView.printMap(bridgeGame.getInput(), WIDTH);
    }

    public void gameResult() {
        OutputView.printResult(bridgeGame.getRetry(), gamePlay());
    }
}
