package bridge.ui;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import javax.xml.validation.Validator;

public class InputView {

    public int readBridgeSize() {
        String bridgeSizeInput =Console.readLine();
        int size = Integer.valueOf(bridgeSizeInput);
        InputValidator.checkBridgeSizeRange(size);
        return size;
    }

    public String readMoving() {
        String direction =Console.readLine();
        InputValidator.checkMovingDirection(direction);
        return direction;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        InputValidator.checkGameCommand(gameCommand);
        return gameCommand;
    }
}
