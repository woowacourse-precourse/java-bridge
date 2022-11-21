package bridge.domain.bridgegame;

import bridge.domain.BridgeGameStarter;
import bridge.io.input.InputView;
import bridge.io.output.OutputView;

public class BridgeGameController implements BridgeGameStarter {
    private final OutputView outputView;
    private final InputView inputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    @Override
    public void start() {
        outputView.printStartMessage();
        inputView.readBridgeSize();
    }
}
