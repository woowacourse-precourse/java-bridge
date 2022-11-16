package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public BridgeGame start() {
        outputView.printStart();
        outputView.printGetLength();
        int BridgeLength = inputView.readBridgeSize();
        while (BridgeLength == 0) {
            BridgeLength = inputView.readBridgeSize();
        }
        return new BridgeGame(bridgeMaker.makeBridge(BridgeLength));
    }

    public boolean play(BridgeGame bridgeGame) {
        outputView.printGetMoving();
        String moving = inputView.readMoving();
        while (moving == null) {
            moving = inputView.readMoving();
        }
        if (!bridgeGame.move(moving)) {
            result(bridgeGame, false);
            return false;
        }
        outputView.printMap(bridgeGame, true);
        return true;
    }

    public void result(BridgeGame bridgeGame, boolean success) {
        outputView.printResult(bridgeGame, success);
    }
}
