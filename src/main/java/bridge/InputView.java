package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getUserInput(String message) {
        System.out.println(message);
        String userInput = Console.readLine();
        return userInput;
    }

    public int readBridgeSize() {
        return 0;
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}