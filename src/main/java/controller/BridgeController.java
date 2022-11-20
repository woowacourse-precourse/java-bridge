package controller;

import bridge.Bridge;
import bridge.BridgeGame;
import constants.BridgeConstants;
import view.InputView;
import view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private int getBridgeSizeFromUser() {
        outputView.printBridgeSizeInputMessage();
        return inputView.readBridgeSize();
    }

    private boolean askToRestart() {
        outputView.printAskToRestart();
        String command = inputView.readGameCommand();
        if (command.equals(BridgeConstants.RESTART)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private void playGame(Bridge bridge, int bridgeSize) {
        boolean isSuccessiveMove = true;

        isSuccessiveMove = isSuccessiveMove(bridge, bridgeSize, isSuccessiveMove);
        if (!isSuccessiveMove) {
            if (askToRestart()) {
                playGame(bridge, bridgeSize);
                return;
            }
        }
        outputView.printResult(bridgeGame.getStateOfBridge(), bridgeGame.getGameTryCount(), isSuccessiveMove);
    }

    private boolean isSuccessiveMove(Bridge bridge, int bridgeSize, boolean isSuccessiveMove) {
        for (int round = 0; isSuccessiveMove && round < bridgeSize; round++) {
            outputView.printMovingInputMessage();
            isSuccessiveMove = bridgeGame.move(bridge, inputView.readMoving(), round);
            outputView.printMap(bridgeGame.getStateOfBridge());
        }
        return isSuccessiveMove;
    }

    public void start() {
        int bridgeSize = getBridgeSizeFromUser();
        Bridge bridge = bridgeGame.generateBridge(bridgeSize);

        playGame(bridge, bridgeSize);
    }
}
