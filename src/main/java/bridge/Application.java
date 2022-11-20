package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView.startGame();
        OutputView.getBridgeSize();

        InputView inputView= new InputView();
        int bridgeSize = inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeMaker.makeBridge(bridgeSize);

    }
}
