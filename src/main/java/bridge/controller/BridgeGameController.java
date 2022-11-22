package bridge.controller;

import bridge.BridgeMaker;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeLane;
import bridge.domain.BridgeSize;
import bridge.domain.GameCommand;

import bridge.BridgeRandomNumberGenerator;

public class BridgeGameController {
    private final OutputView outputView;
    private final InputView inputView;

    private BridgeGame bridgeGame;

    public BridgeGameController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void runGame() {
        try {
            runGameWithoutExceptionControl();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void runGameWithoutExceptionControl() {
        printGameStartAlert();
        BridgeSize bridgeSize = getBridgeSizeInput();
        makeRandomBridge(bridgeSize);

        do {
            getAndProcessNextMovementInput();
        } while(retryOrNot());
        printGameResult();
    }

    private void getAndProcessNextMovementInput() {
        BridgeLane nextMove = getNextMovementInput();
        bridgeGame.move(nextMove);
        printBridgeMap();
    }

    private BridgeLane getNextMovementInput() {
        outputView.printNextMovementInputAlert();
        return inputView.readMoving();
    }

    private void printBridgeMap() {
        outputView.printMap(bridgeGame);
    }

    private boolean retryOrNot() {
        if(bridgeGame.getStatus() == BridgeGame.Status.SUCCESS) {
            return false;
        }
        if(bridgeGame.getStatus() == BridgeGame.Status.FAIL) {
            return getAndProcessGameCommand();
        }
        return true;
    }

    private boolean getAndProcessGameCommand() {
        GameCommand gameCommand = getGameCommandInput();
        if(gameCommand == GameCommand.RETRY) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private GameCommand getGameCommandInput() {
        outputView.printRetryInputAlert();
        return inputView.readGameCommand();
    }

    private void printGameStartAlert() {
        outputView.printGameStartAlert();
        outputView.printEmptyLine();
    }

    private void printGameResult() {
        outputView.printResult(bridgeGame);
    }

    private BridgeSize getBridgeSizeInput() {
        outputView.printBridgeSizeInputAlert();
        BridgeSize bridgeSize =  inputView.readBridgeSize();
        outputView.printEmptyLine();
        return bridgeSize;
    }

    private void makeRandomBridge(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }
}
