package view;

import camp.nextstep.edu.missionutils.Console;
import exceptionHandler.BridgeSizeException;
import exceptionHandler.InputException;

public class InputView {
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        BridgeSizeException.validate(bridgeSize);
        return stringToInteger(bridgeSize);
    }

    public String readMoving() {
        String movingSide = Console.readLine();
        InputException.validateSideSelection(movingSide);
        return movingSide;
    }
    
    public String readGameCommand() {
        String gameCommand = Console.readLine().trim();
        InputException.validateGameCommand(gameCommand);
        return gameCommand;
    }

    private int stringToInteger(String value) {
        return Integer.valueOf(value);
    }
}