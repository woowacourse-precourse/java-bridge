package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        Message.GAME_START.print();
        Message.SIZE_INPUT.print();
        String input = Console.readLine();
        int size = Integer.parseInt(input);
        if (size < Constant.MIN_SIZE_NUM || size > Constant.MAX_SIZE_NUM) {
            Message.ERROR_SIZE.print();
            throw new IllegalStateException(Message.ERROR_SIZE.getMessage());
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Message.MOVE_INPUT.print();
        String command = Console.readLine();
        if (!command.equals("U") && !command.equals("D")) {
            Message.ERROR_MOVE.print();
            throw new IllegalStateException(Message.ERROR_MOVE.getMessage());
        }
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
