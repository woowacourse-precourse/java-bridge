package view;

import camp.nextstep.edu.missionutils.Console;
import exceptionHandler.BridgeSizeException;
import exceptionHandler.GameCommandException;
import exceptionHandler.SideSelectionException;

public class InputView {
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        BridgeSizeException.validate(bridgeSize);
        return stringToInteger(bridgeSize);
    }

    public String readMoving() {
        String movingSide = Console.readLine();
        SideSelectionException.validate(movingSide);
        return movingSide;
    }
    
    public String readGameCommand() {
        String gameCommand = Console.readLine().trim();
        GameCommandException.validate(gameCommand);
        return gameCommand;
    }

    private int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}