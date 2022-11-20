package bridge;

public class Application {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
