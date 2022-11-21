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

    public static String readMoving() {
        while (true) {
            try {
                String userInput = getUserInput(REQUEST_MOVE_COMMAND_MESSAGE.getGuideMessage());
                Validator.validateMoveCommand(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_MOVE_COMMAND_MESSAGE.getErrorMessage());
            }
        }
    }

    public String readGameCommand() {
        return null;
    }
}