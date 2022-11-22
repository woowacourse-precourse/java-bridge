package bridge;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        outputView.printGameStart();
        inputView.readBridgeSize();
    }
}
