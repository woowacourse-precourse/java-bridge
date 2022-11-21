package bridge.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {

    public static String readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        return bridgeSizeInput;
    }

    public static String readMoving() {
        String movementInput = Console.readLine();
        return movementInput;
    }

    public static String readGameCommand() {
        String gameCommandInput = Console.readLine();
        return gameCommandInput;
    }
}
