package bridge.view;

import bridge.exception.BridgeSizeException;
import bridge.exception.CommandException;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    BridgeSizeException bridgeSizeException = new BridgeSizeException();
    CommandException commandException = new CommandException();

    public int readBridgeSize() {

        String bridgeSize = Console.readLine();
        bridgeSizeException.isValidSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving = Console.readLine();
        commandException.isValidMove(moving);
        return moving;
    }


    public String readDecision() {
        String decision = Console.readLine();
        commandException.isValidDecision(decision);
        return decision;
    }
}
