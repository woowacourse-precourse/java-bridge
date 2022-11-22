package bridge;

import camp.nextstep.edu.missionutils.Console;

import constants.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Messages.ENTER_BRIDGE_LENGTH);
        try {
            return checkBridgeSize(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.NOT_IN_RANGE);
        }
    }

    public int checkBridgeSize(int bridgeSize) {
        if (bridgeSize < Constants.SMALLEST_NUMBER || Constants.LARGEST_NUMBER < bridgeSize)
            throw new IllegalArgumentException(Messages.NOT_IN_RANGE);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Messages.ENTER_MOVING);
        return checkMoving(Console.readLine());
    }

    public String checkMoving(String moving) {
        if (!moving.equals(Constants.UP) && !moving.equals(Constants.DOWN))
            throw new IllegalArgumentException(Messages.NOT_MOVING_COMMAND);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Messages.ENTER_GAME_COMMAND);
        return checkGameCommand(Console.readLine());
    }

    public String checkGameCommand(String gameCommand) {
        if (!gameCommand.equals(Constants.RESTART) && !gameCommand.equals(Constants.QUIT))
            throw new IllegalArgumentException(Messages.NOT_GAME_COMMAND);
        return gameCommand;
    }
}
