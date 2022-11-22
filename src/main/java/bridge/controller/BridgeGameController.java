package bridge.controller;

import bridge.bo.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static final String RETRY = "R";
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(Bridge bridge) {
        this.bridgeGame = new BridgeGame(bridge);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void doGame() {
        while (bridgeGame.getBridgeIterator().hasNext()) {
            String answerMove = bridgeGame.getBridgeIterator().next();
            String userMove = inputView.readMoving();
            boolean moveResult = bridgeGame.move(userMove, answerMove);
            outputView.printMap(bridgeGame);
            if (!moveResult) {
                handleFailedMove();
            }
        }
        outputView.printResult(bridgeGame);
    }

    private void handleFailedMove() {
        if (inputView.readGameCommand().equals(RETRY)) {
            bridgeGame.retry();
            return;
        }
        bridgeGame.finish();
    }
}
