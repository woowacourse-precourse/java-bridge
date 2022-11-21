package bridge;

public class BridgeGameStarter {
    private final InputView inputView;

    public BridgeGameStarter() {
        this.inputView = new InputView();
    }

    public void atGameStart() {
        notifyGameStart();
    }

    private void notifyGameStart() {
        this.inputView.printGameStart();
    }
}
