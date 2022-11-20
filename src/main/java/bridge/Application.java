package bridge;

public class Application {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printGameStartMessage();
        int brideSize = inputView.readBridgeSize();
    }
}
