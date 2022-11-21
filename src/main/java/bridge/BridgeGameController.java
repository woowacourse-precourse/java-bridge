package bridge;

public class BridgeGameController {
    OutputView outputView = new OutputView();

    public void gameStart() {
        outputView.printStartMessage();
    }
}
