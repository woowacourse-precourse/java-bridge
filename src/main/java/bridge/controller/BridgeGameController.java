package bridge.controller;

import bridge.*;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.resource.ErrorType;
import bridge.resource.InputType;
import bridge.view.Error;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private boolean isContinue;
    private int countOfAttempt;

    public BridgeGameController() {
        isContinue = true;
        countOfAttempt = 0;
    }

    public void run() {
        OutputView.askBridgeLength();
        makeBridge(InputView.readBridgeSize());

        playGame();

        printResult();
    }

    private void playGame() {
        countOfAttempt++;

        while (isContinue && !bridgeGame.isGameClear()) {
            move();
            OutputView.printMap(bridgeGame.getPath());
        }

        if (!bridgeGame.isGameClear())
            askRestart();
    }

    private void makeBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        try {
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
            this.bridgeGame = new BridgeGame(bridge);
        } catch (IllegalArgumentException e) {
            makeBridge(InputView.readBridgeSize());
        }
    }

    private void move() {
        OutputView.askMovingCommand();
        isContinue = bridgeGame.move(InputView.readMoving());
    }

    private void askRestart() {
        OutputView.askRestartCommand();
        String command = InputView.readGameCommand();

        if (command.equals(InputType.RESTART_COMMAND.getCommand())) {
            retry();
        }
    }

    private void retry() {
        bridgeGame.retry();
        isContinue = true;

        playGame();
    }

    private void printResult() {
        OutputView.printResult(bridgeGame.getPath(), countOfAttempt, bridgeGame.isGameClear());
    }
}
