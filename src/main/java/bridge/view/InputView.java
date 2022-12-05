package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.utils.IntegerConvertor;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.ViewMessages.*;
import static bridge.view.OutputView.printNewLine;

public class InputView {

    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        printNewLine();
        return IntegerConvertor.toInteger(bridgeSize);
    }

    public String readMovingDirection() {
        System.out.println(MOVING);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(GAME_COMMAND);
        return Console.readLine();
    }
}
