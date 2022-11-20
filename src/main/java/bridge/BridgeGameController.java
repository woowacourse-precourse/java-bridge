package bridge;

import java.util.List;

import static bridge.InputView.*;
import static bridge.OutputView.*;

public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    public void start() {
        OutputView.printStart();
        int size = InputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeNumberGenerator).makeBridge(size);
        System.out.println(bridgeList);
    }
}
