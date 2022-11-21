package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int bridgeSize = InputView.readBridgeSize();
        for (int i = 0; i < bridgeSize; i++) {
            BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
            new BridgeMaker(numberGenerator);
        }
    }
}
