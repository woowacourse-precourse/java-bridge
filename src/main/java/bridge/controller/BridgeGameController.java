package bridge;

public class BridgeGameController {
    OutputView outputView = new OutputView();

    public void run() {
        start();
    }

    private void start() {
        outputView.printStart();
    }
}
