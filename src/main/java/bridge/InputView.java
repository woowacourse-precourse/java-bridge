package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Message.GuideMessage.*;
import static bridge.Message.ErrorMessage.*;

public class InputView {
    public static String getUserInput(String message) {
        System.out.println(message);
        String userInput = Console.readLine();
        return userInput;
    }

    public static int readBridgeSize() {
        while (true) {
            try {
                String userInput = getUserInput(REQUEST_BRIDGE_SIZE_MESSAGE.getGuideMessage());
                Validator.validateBridgeSize(userInput);
                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_BRIDGE_SIZE_MESSAGE.getErrorMessage());
            }
        }
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}