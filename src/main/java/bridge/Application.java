package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
