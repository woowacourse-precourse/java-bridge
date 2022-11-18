package bridge;

public class Controller {
    public Controller() {
    }
    private final Model model = new Model();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void inputBridgeLength() {
        Integer bridgeLength = inputView.readBridgeSize();
    }
}
