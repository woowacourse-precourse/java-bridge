package bridge.controller;

import bridge.model.Service.BridgeGame;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputController inputController;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputController = new InputController();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void run() {
        outputView.printStart();
        bridgeGame.makeBridge(inputController.getBridgeSize());
        play();
        outputView.printResult(bridgeGame.getMap(), bridgeGame.getBridgeResult());
    }

    private void play() {
        do {
            bridgeGame.retryGameSetting();
            playRound();
        } while (isReplay());
    }

    private void playRound() {
        for (String moves : bridgeGame.getBridges()) {
            bridgeGame.move(moves, inputController.getMove());
            outputView.printMap(bridgeGame.getMap());
            if (!bridgeGame.isClear()) {
                bridgeGame.failedGame();
                break;
            }
        }
    }

    private boolean isReplay() {
        if (bridgeGame.isLose()) {
            return bridgeGame.retry(inputController.getCommand());
        }
        return false;
    }
}
