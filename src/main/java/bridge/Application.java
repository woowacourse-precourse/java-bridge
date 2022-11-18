package bridge;

import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));

        BridgeGame bridgeGame = new BridgeGame(bridge);

        Result result = new Result();
        for (int i = 0; i < bridgeSize; i++) {
            MoveDirection direction = inputView.readMoving();
            result.updateIsAnswers(bridgeGame.move(direction, i));
        }

    }
}
