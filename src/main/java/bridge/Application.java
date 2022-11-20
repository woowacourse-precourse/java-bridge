package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        int bridgeSize = inputView.readBridgeSize(inputView.readline());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while (true){
            String readMove = inputView.readMoving(inputView.readline());
            boolean move = bridgeGame.move(bridge, readMove);


        }

    }
}
