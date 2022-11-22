package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView.printStartGuide();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.run();
    }
}
