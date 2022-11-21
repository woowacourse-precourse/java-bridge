package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.domain.MoveCommand;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void run() {
        startGame();
        insertBridgeSize();
        insertMoveCommand();
    }

    private void insertMoveCommand() {
        try {
            String command = inputView.readGameCommand();
            new MoveCommand(command);
        } catch (IllegalArgumentException ie) {
            OutputView.printErrorMessage(ie.getMessage());
            insertMoveCommand();
        }
    }

    private void insertBridgeSize() {
        try {
            String size = inputView.readBridgeSize();
            bridgeGame.createBridge(new BridgeSize(size));
        } catch (IllegalArgumentException ie) {
            OutputView.printErrorMessage(ie.getMessage());
            insertBridgeSize();
        }
    }

    private void startGame() {
        outputView.printStartMessage();
    }
}
