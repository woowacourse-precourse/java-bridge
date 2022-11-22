package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView,
            BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void play() {
        outputView.printGameStartMessage();
        List<String> bridge = initialBridge();
        bridgeGame = new BridgeGame(bridge);
    }

    private List<String> initialBridge() {
        int bridgeSize = inputBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private int inputBridgeSize() {
        outputView.printBridgeSizeInputMessage();
        return inputView.readBridgeSize();
    }

    private void playRound() {

    }
}
