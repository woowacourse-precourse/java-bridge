package bridge.view;

import bridge.constant.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.print(PrintMessage.INPUT_BRIDGE_SIZE.getString());
        String inputBridgeSize = Console.readLine();
        if (validateBridgeSize(inputBridgeSize) == false) {
            return readBridgeSize();
        }
        return Integer.parseInt(inputBridgeSize);
    }

    public String readMoving() {
        System.out.print(PrintMessage.INPUT_MOVING.getString());
        String inputMoving = Console.readLine();
        if (validateMoving(inputMoving) == false) {
            return readMoving();
        }
        return inputMoving;
    }

    public String readGameCommand() {
        System.out.print(PrintMessage.INPUT_GAME_COMMAND.getString());
        String inputGameCommand = Console.readLine();
        if (validateMoving(inputGameCommand) == false) {
            return readGameCommand();
        }
        return inputGameCommand;
    }

    private boolean validateBridgeSize(String inputBridgeSize) {
        return true;
    }

    private boolean validateMoving(String Moving) {
        return true;
    }

    private boolean validateGameCommand(String gameCommand) {
        return true;
    }
}
