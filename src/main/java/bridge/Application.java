package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int ERROR = -1;

    private static int size;

    static int checkAndGetBridgeSize(InputView inputView) {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return ERROR;
        }
    }

    static Bridge checkAndMakeBridge(InputView inputView) {
        size = checkAndGetBridgeSize(inputView);
        while(size == ERROR) {
            size = checkAndGetBridgeSize(inputView);
        }
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(bridge, size);
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Bridge bridge = checkAndMakeBridge(inputView);

    }
}
