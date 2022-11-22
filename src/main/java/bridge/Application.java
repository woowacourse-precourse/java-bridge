package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(new InputView(), new OutputView());

        bridgeGame.init();
        do {
            bridgeGame.reset();
            bridgeGame.play();
        } while (bridgeGame.retry());
    }
}
