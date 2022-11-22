package bridge.view;

import bridge.Enum.Message;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        System.out.println(Message.MESSAGE_BRIDGE_SIZE.getValue());
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println(Message.SELECT_DIRECTION.getValue());
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(Message.SELECT_RETRY.getValue());
        return Console.readLine();
    }
}
