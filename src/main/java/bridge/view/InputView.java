package bridge.view;

import static bridge.validator.BridgeValidator.validateBridgeSize;
import static bridge.validator.GameCommandValidator.validateGameCommand;
import static bridge.validator.MovingValidator.validateMoving;
import static camp.nextstep.edu.missionutils.Console.readLine;


public class InputView {


    public int readBridgeSize() {
        String bridgeSize = readLine().trim();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving = readLine().trim();
        validateMoving(moving);
        return moving;
    }
    
    public String readGameCommand() {
        String gameCommand = readLine().trim();
        validateGameCommand(gameCommand);
        return gameCommand;

    }
}
