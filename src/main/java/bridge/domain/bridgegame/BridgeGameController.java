package bridge.domain.bridgegame;

import bridge.domain.BridgeGameStarter;
import bridge.io.output.OutputView;

public class BridgeGameController implements BridgeGameStarter {
    private final OutputView outputView;

    public BridgeGameController() {
        this.outputView = new OutputView();
    }

    @Override
    public void start() {
        outputView.printStartMessage();
    }
}
