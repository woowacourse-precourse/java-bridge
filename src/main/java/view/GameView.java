package view;

public class GameView {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void init() {
        outputView.printStartMessage();
        inputView.readBridgeSize();
        game();
    }

    public void game() {
        inputView.readMoving();
    }
}
