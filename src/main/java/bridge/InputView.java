package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.exceptions.InputException.*;

public class InputView {

    public static int readBridgeSize() throws IllegalArgumentException {
        String bridgeSizeInput = Console.readLine();
        bridgeSizeNumberCheck(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        bridgeSizeRangeCheck(bridgeSize);
        return bridgeSize;
    }

    public static String readMoving() throws IllegalArgumentException {
        String movingInput = Console.readLine();
        movingInputErrorCheck(movingInput);
        return movingInput;
    }

    public static String readGameCommand() {
        String gameCommandInput = Console.readLine();
        gameCommandInputErrorCheck(gameCommandInput);
        return gameCommandInput;
    }
}
