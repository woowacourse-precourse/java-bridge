package bridge;

public class Application {
    static InputView inputView = new InputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
