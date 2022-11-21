package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);


        // make controller with these chunk?

        Integer bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        while (bridgeGame.step < bridgeSize) {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
        }
//        OutputView.printMap(something, bool or int);

    }
}
