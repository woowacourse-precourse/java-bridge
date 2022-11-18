package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    private List<String> bridge_scaffold;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        int bridge_size = inputView.readBridgeSize();
        bridge_scaffold = bridgeMaker.makeBridge(bridge_size);

        BridgeGame bridgeGame = new BridgeGame(bridge_scaffold);

        for (int i = 0; i < bridge_size; i++) {
            String direction = inputView.readMoving();
            if (!bridgeGame.move(direction)) {
                break;
            }
        }

    }
}
