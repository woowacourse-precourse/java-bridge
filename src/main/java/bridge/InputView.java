package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Error.ERROR_INPUT_U_OR_D;
import static bridge.Error.ERROR_SIZE_BRIDGE;
import static bridge.Message.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(PRINT_INPUT_SIZE_BRIDGE.getMessage());
        int bridgeSize = 0;
        bridgeSize = checkSize(bridgeSize);
        return bridgeSize;
    }

    public int checkSize(int bridgeSize) {
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize < 3 || bridgeSize > 20) {
                System.out.println(ERROR_SIZE_BRIDGE.getMessage());
                bridgeSize = readBridgeSize();
            }
        } catch (IllegalStateException | IllegalArgumentException exception) {
            System.out.println(ERROR_SIZE_BRIDGE.getMessage());
        }
        return bridgeSize;
    }

    public String getMove() {
        System.out.println(PRINT_SELECT_THE_CELL_TO_MOVE.getMessage());
        return readMoving();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = null;
        try {
            moving = Console.readLine().toUpperCase();
            return moving;
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(ERROR_INPUT_U_OR_D.getMessage());
        }finally {
            moving = checkMovingNull(moving);
            moving = checkUpAndDown(moving);
        }
        return moving;
    }

    public String checkMovingNull(String moving) {
        if (moving == null) {
            moving = readMoving();
        }
        return moving;
    }

    public String checkUpAndDown(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            System.out.println("");
            moving = readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(PRINT_RETRY_OR_QUIT.getMessage());
        return Console.readLine().toUpperCase();
    }
}
