package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController(new BridgeMaker(new BridgeRandomNumberGenerator()), new InputView(), new BridgeGame(), new OutputView(), new MovingMap());
        bridgeController.run();
    }
}
