package bridge.view;

import bridge.exception.ErrorMsg;
import bridge.model.BridgeInfo;
import bridge.model.Command;
import bridge.model.Direction;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.GET_BRIDGE_LENGTH);
        return Integer.parseInt(
                validated(Console.readLine(), BridgeInfo.getRange(),
                        ErrorMsg.WRONG_BRIDGE_SIZE));
    }

    public <T> T loopInput(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.CHOOSE_UP_OR_DOWN);
        return validated(Console.readLine(), Direction.names(), ErrorMsg.NOT_ALLOWED_MOVEMENT);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.CHOOSE_RETRY);
        return validated(Console.readLine(), Command.names(), ErrorMsg.NOT_ALLOWED_COMMAND);
    }

    private String validated(String move, List<String> allowed, ErrorMsg msg) {
        if (!allowed.contains(move)) {
            throw new IllegalArgumentException(msg.toString());
        }
        return move;
    }
}
