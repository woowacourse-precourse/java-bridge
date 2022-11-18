package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.validate.Validator;

public class InputView {
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        Validator.isNum(bridgeSize);
        Validator.isProperBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String move = Console.readLine();
        Validator.isMove(move);
        return move;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        Validator.isProperGameCommand(gameCommand);
        return gameCommand;
    }
}
