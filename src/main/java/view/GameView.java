package view;

public class GameView {
    private static final OutputView outputView = new OutputView();

    public void init() {
        outputView.printStartMessage();
    }
}
