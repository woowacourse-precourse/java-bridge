package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public void startGame() {
        outputView.printMessage(Message.START);
        outputView.enterLine();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
    }

}
