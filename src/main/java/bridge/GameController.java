package bridge;

import java.util.ArrayList;
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
        while(true) {
            BridgeGame bridgeGame = new BridgeGame(bridge);
            List<String> userPath = new ArrayList<String>();
            bridgeGame.move();
        }
    }

    public int createBridgeSize(InputView inputView) {
        try {
            return Validation.isPositiveInteger(inputView.readBridgeSize());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createBridgeSize(inputView);
        }
    }
}