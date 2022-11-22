package bridge;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        bridgeMaker.makeBridge(bridgeSize);

    }
}
