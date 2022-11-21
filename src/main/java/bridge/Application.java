package bridge;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        output.printStart();
        input.readBridgeSize();
    }
}
