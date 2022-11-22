package view;

import camp.nextstep.edu.missionutils.Console;
import utils.ERROR;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String readBridgeSizeMsg = "다리의 길이를 입력해주세요.";
    private static final String readMovingMsg = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String readGameCommandMsg = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;
    private static final String up = "U";
    private static final String down = "D";
    private static final String restart = "R";
    private static final String quit = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSizeMsg);
        try {
            int bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR.BRIDGE_SIZE);
            return readBridgeSize();
        }
    }

    public void validateBridgeSize(int bridgeSize){
        if (bridgeSize < BRIDGE_SIZE_MIN || bridgeSize > BRIDGE_SIZE_MAX)
            throw new IllegalArgumentException(ERROR.BRIDGE_SIZE);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(readMovingMsg);
        String moving = Console.readLine();

        if (moving.equals(up) || moving.equals(down))
            return moving;

        System.out.println(ERROR.MOVING);
        return readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println(readGameCommandMsg);
        String gameCommand = Console.readLine();

        if (gameCommand.equals(restart) || gameCommand.equals(quit))
            return gameCommand.equals(restart);

        System.out.println(ERROR.GAME_COMMAND);
        return readGameCommand();
    }
}
