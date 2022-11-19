package bridge.view;

import bridge.constant.Messages;
import bridge.domain.BridgeSize;
import bridge.domain.Command;
import bridge.domain.Moving;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static BridgeSize readBridgeSize() {
        System.out.println(Messages.BRIDGE_SIZE_INPUT_MESSAGE);
        return new BridgeSize(Console.readLine());
    }

    public static Moving readMoving() {
        System.out.println(Messages.MOVING_MESSAGE);
        return new Moving(Console.readLine());
    }

    public static Command readGameCommand() {
        System.out.println(Messages.RETRY_MESSAGE);
        return new Command(Console.readLine());
    }
}
