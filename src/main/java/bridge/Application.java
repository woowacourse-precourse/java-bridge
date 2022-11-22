package bridge;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        GameController gameController = new GameController(outputView, inputView, bridgeMaker);

        gameController.readyForGame();
    }
}
