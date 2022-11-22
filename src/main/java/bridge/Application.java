package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printGameStart();
        BridgeGame bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator(), inputView.readBridgeSize());
        while (bridgeGame.keepMove()) {
            bridgeGame.move();
            bridgeGame.retry();
        }
        outputView.printResult(bridgeGame.getResult());
        // TODO: 프로그램 구현
    }
}
