package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Message.GuideMessage.*;

public class InputView {
    public static String getUserInput(String message) {
        System.out.println(message);
        String userInput = Console.readLine();
        return userInput;
    }

    public static int readBridgeSize() {
        String userInput = getUserInput(REQUEST_BRIDGE_SIZE_MESSAGE.getGuideMessage());
        return Integer.parseInt(userInput);
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}