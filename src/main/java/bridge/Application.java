package bridge;

import java.util.List;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();

        int size = 0;
        while (size == 0) {
            try {
                outputView.printInputBridgeSize();
                size = inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(size);

        System.out.println(bridge);
    }
}
