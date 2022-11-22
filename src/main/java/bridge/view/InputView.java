package bridge.view;

import bridge.Enum.Message;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBridgeSize() {
        System.out.println(Message.MESSAGE_BRIDGE_SIZE);
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println(Message.SELECT_DIRECTION);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(Message.SELECT_RETRY);
        return Console.readLine();
    }
}
