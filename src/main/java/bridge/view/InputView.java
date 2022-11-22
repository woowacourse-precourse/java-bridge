package bridge.view;

import bridge.boundary.Console;
import bridge.command.BridgeSize;
import bridge.inputprocessor.InputProcessor;
import bridge.logger.Logger;

public class InputView {

    public BridgeSize readBridgeSize() {
        return new InputProcessor<>(() -> {
            final String userInput = Console.readLine();
            try {
                final int bridgeSize = Integer.parseInt(userInput);
                return BridgeSize.of(bridgeSize);
            } catch (NumberFormatException e) {
                Logger.error("the string does not contain a parsable integer", userInput);
                throw new IllegalArgumentException(e);
            }
        }).process();
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}
