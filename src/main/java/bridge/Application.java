package bridge;

public class Application {
    static InputView inputView = new InputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public static void main(String[] args) {
        bridgeMaker.makeBridge(inputView.readBridgeSize());
        inputView.readMoving();
    }
}
