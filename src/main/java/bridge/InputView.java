package bridge;

import camp.nextstep.edu.missionutils.Console;

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
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize < 3 || bridgeSize > 20) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                bridgeSize = readBridgeSize();
            }
        } catch (IllegalStateException | IllegalArgumentException exception) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
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
            System.out.println("[ERROR] U 또는 D를 입력해주세요");
        }finally {
            moving = checkMovingNull(moving);
            checkUpAndDown(moving);
        }
        return moving;
    }

    private String checkMovingNull(String moving) {
        if (moving == null) {
            moving = readMoving();
        }
        return moving;
    }

    private void checkUpAndDown(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            System.out.println("[ERROR] U 또는 D를 입력해주세요");
            moving = readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(PRINT_RETRY_OR_QUIT.getMessage());
        return Console.readLine().toUpperCase();
    }
}
