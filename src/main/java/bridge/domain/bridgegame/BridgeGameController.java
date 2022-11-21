package bridge.domain.bridgegame;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGameStarter;
import bridge.io.input.InputView;
import bridge.io.output.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController implements BridgeGameStarter {
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private List<String> bridge;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new ArrayList<>();
    }

    @Override
    public void start() {
        outputView.printStartMessage();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
