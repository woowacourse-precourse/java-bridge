package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

import static bridge.view.Message.ERROR_NOT_INTEGER;
import static bridge.view.Message.ERROR_OVER_RANGE;

public class BridgeService {
    private static int inputSize;

    public static int getInitBridgeSize() {
        while (true) {
            String input = InputView.readBridgeSize();
            try {
                inputSize = checkInteger(input);
                checkRange(inputSize);
                return inputSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputSize);
    }

    public static int checkInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public static void checkRange(int input) {
        if (input < 3 || input > 21) {
            throw new IllegalArgumentException(ERROR_OVER_RANGE);
        }
    }
}
