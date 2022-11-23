package bridge.view;

import bridge.constant.Messages;
import bridge.domain.BridgeSize;
import bridge.domain.Command;
import bridge.domain.Moving;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static BridgeSize readBridgeSize() {
        System.out.println(Messages.BRIDGE_SIZE_INPUT_MESSAGE);
        try {
            return new BridgeSize(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public static Moving readMoving() {
        System.out.println(Messages.MOVING_MESSAGE);
        try {
            return new Moving(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public static Command readGameCommand() {
        System.out.println(Messages.RETRY_MESSAGE);
        try {
            return new Command(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
