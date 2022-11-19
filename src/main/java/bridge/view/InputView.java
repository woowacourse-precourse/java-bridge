package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.InputException.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();

        isValidBridgeSizeType(bridgeSize);
        isValidBridgeSizeRange(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String movementDirection = Console.readLine();

        isValidMovementDirection(movementDirection);

        return movementDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return Console.readLine();
    }
}
