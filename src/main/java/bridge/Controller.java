package bridge;

public class Controller {
    private static  BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private static  BridgeMaker bridgeMaker;

    public Controller() {

    }

    public void startGame() {
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    }
}
