package bridge;

public class BridgeGameStarter {
    private final OutputView outputView;

    public BridgeGameStarter() {
        this.outputView = new OutputView();
    }

    public void atGameStart() {
        notifyGameStart();
    }

    private void notifyGameStart() {
        this.outputView.printGameStart();
    }
}
