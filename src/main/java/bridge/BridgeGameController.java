package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    private List<String> bridgeScaffold;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeScaffold = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame(bridgeScaffold);

        for (int i = 0; i < bridgeSize; i++) {
            String direction = inputView.readMoving();
            if (!bridgeGame.move(direction)) {
                break;
            }
        }

    }
}
