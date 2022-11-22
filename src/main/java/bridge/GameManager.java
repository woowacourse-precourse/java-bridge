package bridge;

public class GameManager {
    final InputView inputView;
    final OutputView outputView;

    GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void showGameTitle() {
        outputView.printGameTitle();
    }
}
