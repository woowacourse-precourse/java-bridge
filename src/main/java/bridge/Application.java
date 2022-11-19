package bridge;

import static bridge.utils.message.GameMessagesUtil.INPUT_BRIDGE_SIZE;
import static bridge.utils.message.GameMessagesUtil.START;

import bridge.utils.console.InputView;
import bridge.utils.console.OutputView;
import java.util.List;

public class Application {
    private static InputView input = new InputView();
    private static OutputView output = new OutputView();

    public static void main(String[] args) {
        List<String> bridge = getBridge();
        System.out.println("bridge = " + bridge);
    }

    private static List<String> getBridge() {
        output.printMessage(START.getMessage());
        List<String> bridge = makeBridge();
        output.printMessage();

        return bridge;
    }

    private static List<String> makeBridge() {
        int bridgeSize = readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static int readBridgeSize() {
        while (true) {
            try {
                output.printMessage(INPUT_BRIDGE_SIZE.getMessage());
                return input.readBridgeSize();
            } catch (IllegalArgumentException ex) {
                output.printMessage(ex.getMessage());
            }
        }
    }

}
