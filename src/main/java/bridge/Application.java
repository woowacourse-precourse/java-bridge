package bridge;

public class Application {

    public static void main(String[] args) {
        new Controller(
                new InputViewRetryProxy(new InputView()),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator())
        ).start();
    }
}
