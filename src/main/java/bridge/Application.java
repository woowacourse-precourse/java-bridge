package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, inputView.readBridgeSize());
        bridgeGame.playGame();
    }
}
