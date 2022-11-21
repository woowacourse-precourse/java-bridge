package bridge.view;

import bridge.commom.validation.InputValidator;

import camp.nextstep.edu.missionutils.Console;

import static bridge.commom.constant.GameMessage.InputMessage.*;

public class InputView {

    public int readBridgeSize() {
        String input = printMessageAndReadLine(READ_BRIDGE_SIZE);
        InputValidator.isPositiveInteger(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = printMessageAndReadLine(READ_MOVEMENT);
        InputValidator.isMoveModeCommand(input);
        return input;
    }

    public String readGameCommand() {
        String input = printMessageAndReadLine(READ_GAME_COMMAND);
        InputValidator.isRestartModeCommand(input);
        return input;
    }

    private String printMessageAndReadLine(String message) {
        System.out.println(message);
        return readLineWithoutWhiteSpace();
    }

    private String readLineWithoutWhiteSpace() {
        return Console.readLine().replaceAll(" ", "");
    }
}
