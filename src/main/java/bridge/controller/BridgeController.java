package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.commom.constant.GameState;
import bridge.model.BridgeHistory;
import bridge.BridgeManager;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.HashMap;

import static bridge.commom.constant.GameCommand.isRestartCommand;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeHistory bridgeHistory;
    private BridgeManager bridgeManager;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void playGreeting() {
        outputView.printGreeting();
    }

    public void setupGame() {
        int size = inputView.readBridgeSize();
        bridgeHistory = new BridgeHistory(new HashMap<>(), size);
        bridgeManager = new BridgeManager(new BridgeRandomNumberGenerator());
        bridgeManager.setBridgeWithSize(size);
    }

    public GameState getNowGameProgress() {
        return bridgeHistory.getProgress();
    }

    public void moveOneStep() {
        String userCommand = inputView.readMoving();
        boolean isMovable = bridgeManager.isMovable(userCommand, bridgeHistory.getNowStage());
        bridgeHistory.updateGameState(userCommand, isMovable);
        outputView.printMap(bridgeHistory);
    }

    public boolean figureOutToRestartGame() {
        String userCommand = inputView.readGameCommand();
        return isRestartCommand(userCommand);
    }

    public void restartGame() {
        bridgeHistory.resetHistory();
    }

    public void showResult() {
        outputView.printResult(bridgeHistory);
    }
}
