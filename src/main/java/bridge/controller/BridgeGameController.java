package bridge.controller;

import bridge.*;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Count;
import bridge.resource.InputType;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private Count countOfAttempt;
    private boolean isContinue;

    public BridgeGameController() {
        countOfAttempt = new Count();
        isContinue = true;
    }

    public void run() {
        OutputView.askBridgeLength();
        makeBridge(InputView.readBridgeSize());

        playGame();

        printResult();
    }

    private void playGame() {
        countOfAttempt.increase();

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
        OutputView.printResult(bridgeGame.getPath(), countOfAttempt.getCount(), bridgeGame.isGameClear());
    }
}
