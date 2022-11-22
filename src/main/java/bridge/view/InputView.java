package bridge.view;

import static bridge.exception.IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_LENGTH;

import bridge.bridge.BridgePosition;
import bridge.bridgeGame.GameCommand;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_BRIDGE_LENGTH.getMessage());
        }
    }

    public BridgePosition readMoving() throws IllegalArgumentException {
        String moving = Console.readLine();
        return BridgePosition.fromString(moving);
    }

    public GameCommand readGameCommand() throws IllegalArgumentException {
        String gameCommand = Console.readLine();
        return GameCommand.fromString(gameCommand);
    }
}
