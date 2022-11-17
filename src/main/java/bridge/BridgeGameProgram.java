package bridge;

public class BridgeGameProgram {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameProgram(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStartComment();
    }
}
