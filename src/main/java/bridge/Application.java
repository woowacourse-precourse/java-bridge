package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.viewGameStartMessage();
        inputView.checkBridgeValidate();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(inputView.getSize());
        System.out.println(bridge);
        String input = inputView.readMoving();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(input, bridge);
        OutputView outputView = new OutputView();
        outputView.printMap(input, bridge);
    }
}
