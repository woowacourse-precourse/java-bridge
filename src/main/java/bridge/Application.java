package bridge;


public class Application {

    private static final OutputView outputView = OutputView.getInstance();

    public static void main(String[] args) {
        outputView.printStart();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.run();
    }
}
