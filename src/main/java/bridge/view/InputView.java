package bridge.view;

import bridge.util.validator.BridgeLengthValidator;
import bridge.util.validator.GameCommandValidator;
import bridge.util.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        String input = Console.readLine();
        BridgeLengthValidator.validate(input);
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize;
    }

    public String readMoving() {
        String SpaceToMove = Console.readLine();
        MovingValidator.validate(SpaceToMove);
        return SpaceToMove;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        GameCommandValidator.validate(gameCommand);
        return gameCommand;
    }
}
