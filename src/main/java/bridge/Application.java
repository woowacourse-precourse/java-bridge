package bridge;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int bridgeSize = inputView.readBridgeSize();
        bridgeMaker.makeBridge(bridgeSize);
        String moveCommand = inputView.readMoving();
    }
}
