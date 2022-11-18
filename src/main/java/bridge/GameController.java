package bridge;

import java.util.List;

import static bridge.Validation.*;

public class GameController {
    public GameController() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printStartGame();
        int bridgeSize = createBridgeSize(inputView);
        Validation.isInRange(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

    }

    public int createBridgeSize(InputView inputView) {
        try {
            return Validation.isPositiveInteger(inputView.readBridgeSize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Validation.isPositiveInteger(inputView.readBridgeSize());
        }
    }
}