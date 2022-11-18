package bridge;

public class GameManager {
    InputView inputView;
    OutputView ouputView;


    public GameManager(InputView input, OutputView output) {
        this.inputView = new InputView();
        this.ouputView = new OutputView();
    }

    public void start() {
        ouputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
    }
}
