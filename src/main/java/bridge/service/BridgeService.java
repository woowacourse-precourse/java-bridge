package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;

import static bridge.domain.SuccessOrFail.실패;

import java.util.*;

public class BridgeService {

    static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static final BridgeGame bridgeGame = new BridgeGame(0);
    static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    static final InputValidation inputValidation = new InputValidation();
    static final InputView inputView = new InputView();
    static final OutputView outputView = new OutputView();

    public void bridgeGameStart() {
        outputView.printGameStartMessage();
        int bridgeLength = inputBridgeLength();
        makeBridge(bridgeLength);
        RepeatPlayerMoveBeforeGameFinish();
        outputView.printResult(bridgeGame);
    }

    public int inputBridgeLength() {
        while (true) {
            outputView.printRequestBridgeLengthMessage();
            String bridgeLength = inputView.readBridgeSize();
            if (!isValidBridgeLengthInput(bridgeLength))
                continue;

            return Integer.parseInt(bridgeLength);
        }
    }

    public boolean isValidBridgeLengthInput(String bridgeLength) {
        if (!inputValidation.isNumber(bridgeLength)) {
            outputView.printNotNumberBridgeLengthInputErrorMessage();
            return false;
        }
        if (!inputValidation.isValidRange(Integer.parseInt(bridgeLength))) {
            outputView.printInValidRangeBridgeLengthErrorMessage();
            return false;
        }
        return true;
    }

    public void makeBridge(int bridgeLength) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame.initializeBridgeGameAtGameStart(bridge);
    }

    public void RepeatPlayerMoveBeforeGameFinish() {
        boolean doRetry = true;
        while (!bridgeGame.isFinish()) {
            if (!inputPlayerMoveDirectionAndValidation())
                continue;
            outputView.printMap(bridgeGame);
            if (!doRetry(doRetry))
                return;
        }
        bridgeGame.gameSuccess();
    }

    private boolean doRetry(boolean doRetry) {
        if (bridgeGame.isMoveSuccess().equals(실패))
            doRetry = bridgeGame.retry(inputGameRetryCommandAndValidation());
        if (!doRetry)
            outputView.printResult(bridgeGame);

        return doRetry;
    }

    public boolean inputPlayerMoveDirectionAndValidation() {
        outputView.printRequestMoveDirectionMessage();
        String moveDirection = inputView.readMoving();

        if (!inputValidation.isValidDirection(moveDirection)) {
            outputView.printInValidMoveDirectionErrorMessage();
            return false;
        }
        bridgeGame.move(moveDirection, bridgeGame.getBridgeIdx());
        return true;
    }

    public String inputGameRetryCommandAndValidation() {
        while (true) {
            outputView.printRetryGameMessage();
            String gameRetryCommand = inputView.readGameCommand();
            if (!inputValidation.isValidGameRetryInput(gameRetryCommand)) {
                outputView.printRetryGameErrorMessage();
                continue;
            }
            return gameRetryCommand;
        }
    }
}
