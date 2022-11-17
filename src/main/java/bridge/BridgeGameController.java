package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    private List<String> bridge_scaffold;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        int bridge_size = inputView.readBridgeSize();
        bridge_scaffold = bridgeMaker.makeBridge(bridge_size);

        System.out.println(bridge_scaffold);

    }
}
