package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeGame bridgeGame = new BridgeGame(bridgeSize);

            while (true) {
                if (!continueGame(bridgeGame)) {
                    outputView.printResult();
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private boolean continueGame(BridgeGame bridgeGame) {
        String movement = inputView.readMoving();
        boolean isPass = bridgeGame.move(movement);
        boolean isSuccess = bridgeGame.checkSuccess();

        outputView.printMap(bridgeGame);

        return isContinue(bridgeGame, isPass, isSuccess);
    }

    private boolean isContinue(BridgeGame bridgeGame, boolean isPass, boolean isSuccess) {
        if (isPass && isSuccess) {
            return false;
        }

        if (!isPass) {
            String command = inputView.readGameCommand();
            return bridgeGame.retry(command);
        }

        return true;
    }
}
