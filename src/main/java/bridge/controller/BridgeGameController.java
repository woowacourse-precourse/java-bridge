package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.validator.InputBridgeSizeValidator;
import bridge.validator.InputMovingValidator;
import bridge.validator.InputRetryOrExitValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void startGame() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            InputBridgeSizeValidator.validateBridgeSize(bridgeSize);

            BridgeGame bridgeGame = new BridgeGame(bridgeSize, bridgeMaker);
            playGame(bridgeGame);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void playGame(BridgeGame bridgeGame) {
        while (true) {
            if (!continueGame(bridgeGame)) {
                outputView.printResult(bridgeGame);
                return;
            }
        }
    }

    private boolean continueGame(BridgeGame bridgeGame) {
        String movement = inputView.readMoving();
        InputMovingValidator.validateMovingInput(movement);

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
            InputRetryOrExitValidator.validateRetryOrExitCommand(command);
            return bridgeGame.retry(command);
        }

        return true;
    }
}
