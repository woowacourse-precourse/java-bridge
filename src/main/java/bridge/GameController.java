package bridge;

import bridge.support.ResultGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public GameController(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        outputView.printGameStart();
    }

    public void execute() {
        int bridgeSize = readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));

        BridgeGame bridgeGame = new BridgeGame(bridge);
        Result result = ResultGenerator.generateResult(bridgeSize, bridgeGame);

    }

    private int readBridgeSize() {
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }
}
