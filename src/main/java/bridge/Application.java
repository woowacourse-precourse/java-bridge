package bridge;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();
        outputView.printBridgeSize();
        inputView.readBridgeSize();
    }
}
