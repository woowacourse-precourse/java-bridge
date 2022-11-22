package bridge;

import java.util.List;

public class Application {

    private static int inputBridgeSize(InputView inputView) {
        int bridgeSize = 0;
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeSize;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputBridgeSize(inputView));





    }
}
