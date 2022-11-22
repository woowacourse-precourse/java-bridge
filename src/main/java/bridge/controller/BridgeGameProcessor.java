package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.User;
import bridge.util.InformationMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameProcessor {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameProcessor(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = initBridgeGame(initUser(generateBridge(bridgeMaker)));
    }

    public void playGame() {
        outputView.printStartMessage();
        while (!isOver()) { }
    }

    private boolean isOver() {
        if (!isKeepMoving()) {
            printResult(InformationMessage.FAILURE);
            return true;
        }
        if (bridgeGame.isFinished()) {
            printResult(InformationMessage.SUCCESS);
            return true;
        }
        return false;
    }

    private void printResult(InformationMessage successOrNot) {
        outputView.printEndMessage();
        outputView.printMap(bridgeGame.getUpBridgeMoveResult(), bridgeGame.getDownBridgeResult());
        outputView.printSuccessOrNot(successOrNot);
        outputView.printTrialCount(bridgeGame.getTrialCount());
    }

    private boolean isKeepMoving() {
        boolean isSuccessMoving = isSuccessMoved();
        outputView.printMap(bridgeGame.getUpBridgeMoveResult(), bridgeGame.getDownBridgeResult());
        if (isSuccessMoving) {
            return true;
        }

        return isRetried();
    }

    private boolean isRetried() {
        while (true) {
            try {
                outputView.printGameCommandSelectionMessage();
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isSuccessMoved() {
        while (true) {
            try {
                outputView.printPositionSelectionMessage();
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BridgeGame initBridgeGame(User user) {
        return new BridgeGame(user);
    }

    private User initUser(Bridge bridge) {
        return new User(bridge);
    }

    private Bridge generateBridge(BridgeMaker bridgeMaker) {
        while (true) {
            try {
                outputView.printBridgeSizeInputMessage();
                return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
