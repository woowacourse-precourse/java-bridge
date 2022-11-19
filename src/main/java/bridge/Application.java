package bridge;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager(new InputView(), new OutputView(), new BridgeRandomNumberGenerator());
        gameManager.start();
    }
}
