package bridge.service;

import bridge.view.InputView;

import static bridge.view.Message.*;

public class BridgeService {

    public static int getInitBridgeSize() {
        while (true) {
            String input = InputView.readBridgeSize();
            try {
                int inputSize = checkInteger(input);
                checkRange(inputSize);
                return inputSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
