package bridge.view;

import bridge.utils.Notice;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    final int MIN_SIZE = 3;
    final int MAX_SIZE  = 20;
    final String UP_MOVING = "U";
    final String DOWN_MOVING = "D";
    final String RETRY = "R";
    final String END = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();

        try {
            return checkBrideSizeRange(Integer.parseInt(size));
        } catch (IllegalArgumentException e) {
            System.out.println(Notice.ERROR.getMessage());
        }
        return readBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        try {
            return checkMoving(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(Notice.ERROR.getMessage());
        }
        return readMoving();

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        try {
            return checkGameCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(Notice.ERROR.getMessage());
        }
        return readGameCommand();
    }

    private int checkBrideSizeRange(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException();
        }

        return size;
    }

    private String checkMoving(String move) {
        if (!(move.equals(UP_MOVING) || move.equals(DOWN_MOVING))) {
            throw new IllegalArgumentException();
        }

        return move;
    }

    private String checkGameCommand(String gameCommand) {
        if (!(gameCommand.equals(RETRY) || gameCommand.equals(END))) {
            throw new IllegalArgumentException();
        }

        return gameCommand;
    }

}
