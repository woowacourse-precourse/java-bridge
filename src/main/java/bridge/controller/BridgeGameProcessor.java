package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.util.InformationMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameProcessor {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameProcessor(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void play() {
        outputView.printStartMessage();
        BridgeGame bridgeGame = setBridgeGame(setBridge());
        while (isContinue(bridgeGame)) {
        }

    }

    private boolean isContinue(BridgeGame bridgeGame) {
        if (!isPlayStage(bridgeGame)) {
            outputView.printResult(bridgeGame.getMapOfUpBridge(), bridgeGame.getMapOfDownBridge(), bridgeGame.getTrialCount(), InformationMessage.FAILURE);
            return false;
        }
        if (bridgeGame.isFinished()) {
            outputView.printResult(bridgeGame.getMapOfUpBridge(), bridgeGame.getMapOfDownBridge(), bridgeGame.getTrialCount(), InformationMessage.SUCCESS);
            return false;
        }
        return true;
    }

    private boolean isPlayStage(BridgeGame bridgeGame) {
        boolean moving = isMoving(bridgeGame);
        outputView.printMap(bridgeGame.getMapOfUpBridge(), bridgeGame.getMapOfDownBridge());
        if (moving) {
            return true;
        }

        return isRetry(bridgeGame);
    }

    private boolean isRetry(BridgeGame bridgeGame) {
        while (true) {
            try {
                outputView.printGameCommandSelectionMessage();
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isMoving(BridgeGame bridgeGame) {
        while (true) {
            try {
                outputView.printPositionSelectionMessage();
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BridgeGame setBridgeGame(Bridge bridge) {
        return new BridgeGame(bridge);
    }

    private Bridge setBridge() {
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
