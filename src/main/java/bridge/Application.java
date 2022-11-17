package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker newBridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView input = new InputView();
        newBridge.makeBridge(input.readBridgeSize());
    }
}
