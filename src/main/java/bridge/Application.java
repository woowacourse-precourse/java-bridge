package bridge;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        String moving;
        int bridgePositionIndex = 0;
        BridgeGame bridgeGame = new BridgeGame();
        while (bridgePositionIndex < bridge.size()) {
            moving = inputView.readMoving();
            bridgeGame.move(new Bridge(bridge.get(bridgePositionIndex), moving));
            outputView.printMap(bridgeGame, bridgePositionIndex);
            bridgePositionIndex++;
        }
    }
}