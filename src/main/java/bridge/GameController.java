package bridge;

public class GameController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();

    public void start() {
        output.printStart();
        output.printInputBridgeSize();
        int bridgeSize = input.readBridgeSize();
    }
}
