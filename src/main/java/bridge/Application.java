package bridge;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();
        outputView.printAskingBridgeSize();
        bridgeMaker.makeBridge(inputView.readBridgeSize());
        outputView.printAskingMoving();
        inputView.readMoving();
    }
}
