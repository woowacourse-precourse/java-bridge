package bridge;

public class MainGame {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private boolean endGame;

    public MainGame() {
        endGame = false;
        outputView.printStart();
        outputView.printLengthInput();
        inputView.readBridgeSize();
        playRound();
    }

    public void playRound() {

    }

}
