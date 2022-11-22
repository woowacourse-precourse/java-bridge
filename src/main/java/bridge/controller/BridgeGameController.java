package bridge.controller;

import bridge.BridgeMaker;

import bridge.domain.*;

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
        printGameStartAlert();
        BridgeSize bridgeSize = getBridgeSizeInput();
        makeRandomBridge(bridgeSize);

        do {
            getAndProcessNextMovementInput();
        } while(retryOrNot());
        printGameResult();
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

    private void makeRandomBridge(BridgeSize bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }

    private void printGameStartAlert() {
        outputView.printGameStartAlert();
        outputView.printEmptyLine();
    }

    private void printBridgeMap() {
        outputView.printMap(bridgeGame);
    }

    private void printGameResult() {
        outputView.printResult(bridgeGame);
    }

    private void getAndProcessNextMovementInput() {
        BridgeLane nextMove = getNextMovementInput();
        bridgeGame.move(nextMove);
        printBridgeMap();
    }

    private boolean getAndProcessGameCommand() {
        GameCommand gameCommand = getGameCommandInput();
        if(gameCommand == GameCommand.RETRY) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private BridgeSize getBridgeSizeInput() {
        outputView.printBridgeSizeInputAlert();
        BridgeSize bridgeSize = (BridgeSize) getInputUntilValidInput(() -> inputView.readBridgeSize());
        outputView.printEmptyLine();
        return bridgeSize;
    }

    private BridgeLane getNextMovementInput() {
        outputView.printNextMovementInputAlert();
        return (BridgeLane) getInputUntilValidInput(() -> inputView.readMoving());
    }

    private GameCommand getGameCommandInput() {
        outputView.printRetryInputAlert();
        return (GameCommand) getInputUntilValidInput(() -> inputView.readGameCommand());
    }

    private Validatable getInputUntilValidInput(InputFunction inputFunction) {
        try {
            return inputFunction.readInput();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getInputUntilValidInput(inputFunction);
        }
    }

    private interface InputFunction {
        Validatable readInput();
    }
}
