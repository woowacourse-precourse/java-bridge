package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.GameCommand;
import bridge.domain.Move;
import bridge.InputView;

public class InputController {

    public static Bridge inputBridgeSize() {
        return new Bridge(InputView.readBridgeSize());
    }

    public static Move inputMoving() {
        return new Move(InputView.readMoving());
    }

    public static GameCommand inputGameCommand() {
        return new GameCommand(InputView.readGameCommand());
    }

}
