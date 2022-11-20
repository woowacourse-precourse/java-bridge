package bridge.controller;

import static bridge.BridgeGame.generateBridge;

import bridge.domain.Bridge;
import bridge.domain.MovingCommand;
import bridge.domain.SizeOfBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.printStartMessage();
        set();
        playGame();
    }

    private void set() {
        SizeOfBridge sizeOfBridge = inputView.readBridgeSize();
        Bridge bridge = generateBridge(sizeOfBridge);
    }

    private void playGame() {
        MovingCommand movingCommand = inputView.readMoving();
    }

}
