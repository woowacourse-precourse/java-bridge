package bridge.utils.console;


import static bridge.utils.Move.getMove;
import static bridge.utils.Move.validateMove;
import static bridge.utils.message.ErrorMessagesUtil.RETRY_COMMAND;

import bridge.utils.BridgeSize;
import bridge.utils.Move;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return new BridgeSize(Console.readLine()).getSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        String move = Console.readLine();
        validateMove(move);
        return getMove(move);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        validateCommand(command);

        return command;
    }

    private void validateCommand(String command) {
        if (command.equals("R") || command.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException(RETRY_COMMAND.getMessage());
    }
}
