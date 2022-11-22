package bridge;

public class GameController {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;

    GameController() {
        inputView = new InputView();
        outputView = new OutputView();

    }

    private void simulate() {

    }

    private void ending() {

    }

    public void run() {
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        simulate();
        ending();
    }
}
