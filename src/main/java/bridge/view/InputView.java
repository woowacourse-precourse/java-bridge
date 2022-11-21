package bridge.view;

import bridge.util.BridgeGameValidator;
import bridge.util.Message;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final BridgeGameValidator bridgeGameValidator;

    public InputView()
    {
        bridgeGameValidator = new BridgeGameValidator();
    }
    private String readLine()
    {
        return Console.readLine();
    }

    public int readBridgeSize() {
        try {
            int bridgeSize = Integer.parseInt(readLine());
            bridgeGameValidator.validateBridgeSize(bridgeSize);
            return bridgeSize;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ILLEGAL_BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }

    public String readMoving() {
        String userInputForMove = readLine();
        bridgeGameValidator.validateUserInputForMove(userInputForMove);
        return userInputForMove;
    }

    public String readGameCommand() {
        String gameCommand = readLine();
        bridgeGameValidator.validateGameCommand(gameCommand);
        return gameCommand;
    }

}
